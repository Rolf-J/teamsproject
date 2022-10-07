import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TEAMS{
    static ArrayList<Student> students;
    static ArrayList<Teacher> teachers;
    static ArrayList<Course> courses;

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        
        //Load the data if available ### DO NOT CHANGE THIS PART
        try{
            students =(ArrayList<Student>)loadData("students");

        }catch(Exception e){
            students = new ArrayList<>();
        }
        try{
            teachers =(ArrayList<Teacher>)loadData("teachers");
        }catch(Exception e){
            teachers = new ArrayList<>();
        }
        try{
            courses =(ArrayList<Course>)loadData("courses");
        }catch(Exception e){
            courses = new ArrayList<>();
        }


        //############## MAIN MENU STARTS HERE ##############
        int ans = 0;

        while(ans != 0){
            System.out.println("1.Add Student\n2.Add Teacher\n3.Add Course\n4.Edit Student\n5.List Student\n6.List Courses\n7.Search for Student\n0.Exit");

            if(ans == 1){ //add student
                System.out.println("Enter student name: ");
                String sname = sc.nextLine();
                System.out.println("Enter grade level");
                int level = sc.nextInt();
                Student s = new Student(sname,level);
                students.add(s);
            }
            
            if(ans == 2){ //add teacher
                System.out.println("Enter teacher name: ");
                String tname = sc.nextLine();
                System.out.println("Enter years of experience: ");
                int experience = sc.nextInt();
                Teacher t = new Teacher(tname,experience);
                teachers.add(t);
            }

            if(ans == 3){ //add course
                System.out.println("Enter subject: ");
                String subject = sc.nextLine();
                System.out.println("Pick a teacher: ");
                listTeachers();                                 //DEFINE****
                String teacher = sc.nextLine(index);            //HOW TO CHOOSE A TEACHER FROM ARRAY LIST
                Course c = new Course(subject, teacher);
                courses.add(c);
            }

            if(ans == 4){ // edit student
               //add course to schedule
               if(ans == __){
                System.out.println("Pick a class:")
                listCourses();
               }
            }

            if(ans == 5){ // list courses
                System.out.println(courses);                        //DEFINE***
            }

            if(ans == 6){ //list Students
                listStudents();                                      //DEFINE****
            }

            if(ans == 7){ //search for student
                System.out.println(students);

            }

            if(ans == 0){ //Exit

            }
        }
        

    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(students);
        os.close();
        f1.close();

        FileOutputStream f2 = new FileOutputStream("courses");
        os = new ObjectOutputStream(f2);
        os.writeObject(courses);
        os.close();
        f2.close();

        FileOutputStream f3 = new FileOutputStream("teachers");
        os = new ObjectOutputStream(f3);
        os.writeObject(teachers);
        os.close();
        f3.close();
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}