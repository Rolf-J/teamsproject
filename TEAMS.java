import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TEAMS {
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
                for(int i = 0; i<teachers.size(); i++){
                    System.out.println(i +""+teachers.get(i));
                }                
                System.out.println("Choice:");
                int choice = sc.nextInt();
                sc.nextLine();
                Teacher teacher = teachers.get(choice); 
                Course c = new Course(subject, teacher);
                courses.add(c);
            }

            if(ans == 4){ // edit student
                System.out.println("Choose a student: ");
                    for(int i = 0; i<students.size(); i++){
                        System.out.println(i +""+students.get(i));
                    }
                    int choice = sc.nextInt();
                    sc.nextLine();
                    Student s = students.get(choice);
                    System.out.println("1. Modify name\n2. Modify Grade Level\n3. Add Class\n4.Remove class");
                    int choice2 = sc.nextInt();
                    sc.nextLine();
                    if(choice2 == 1){
                        System.out.println("New name: ");
                        String newName = sc.nextLine();
                        s.setSname(newName);
                    }
                    if(choice2 == 2){
                        System.out.println("New Grade Level: ");
                        int newGrade = sc.nextInt();
                        sc.nextLine();
                        s.setLevel(newGrade);
                    }
                    if(choice2 == 3){
                        System.out.println("Pick a class:");
                        for(int i = 0; i<courses.size(); i++){
                            System.out.println(i +""+courses.get(i));
                        }
                        int choice3 = sc.nextInt();
                        Course c = courses.get(choice3).clone();
                        System.out.println("Enter grade");
                        int grade =  sc.nextInt();
                        sc.nextLine();
                        c.setGrade(grade);
                        System.out.println("Currently taking it?");
                        String yn = sc.nextLine();
                        boolean current =false;
                        if(yn.equals(("y"))){
                            current = true;
                        }       
                        c.setCurrent(current);
                        s.addCourse(c);
                    }
                    if(ans == 4){
                        System.out.println("Pick a Class: ");
                        ArrayList<Course> courses = s.getCourses();
                        for(int i = 0; i<courses.size(); i++){
                            System.out.println(i +""+courses.get(i));
                        }
                        int choice4 = sc.nextInt();
                        sc.nextLine();
                        Course c = courses.get(choice4);
                        s.removeCourse(c);
                    }
            }

            if(ans == 5){ // list courses
                for(int i = 0; i<courses.size(); i++){
                    System.out.println(i +""+courses.get(i));
                } 
            }

            if(ans == 6){ //list Students
                for(int i = 0; i<students.size(); i++){
                    System.out.println(i +""+students.get(i));
                }                
            }

            if(ans == 7){ //search for student
                boolean found = false;
                System.out.print("Enter name: ");
                String search = sc.nextLine();
                for(int i = 0; i<students.size(); i++){
                    Student s = students.get(i);
                    if(s.getSname().equals(search)){
                        System.out.println(s);
                        found = true;
                    }
                }  
                if(!found){
                    System.out.print("Not found.");
                }

            }

            if(ans == 0){ //Exit
                try{

                    saveData();
                    
                    }catch(Exception e){}
            }
        }
    }

    // #### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData() throws Exception {
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

    // #### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception {
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}

