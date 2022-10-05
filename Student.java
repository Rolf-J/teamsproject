import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    //instance variables
    private String sname;
    private int level;
    private ArrayList<Course> courses;

    //constructors
    public Student (String sname, int level){
        this.sname = sname;
        this.level = level;
        courses = new ArrayList<>();
    }

    //getters
    public String getSname(){
        return sname;
    }
    public int getLevel(){
        return level;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }

    //setters
    public void setSname(String sname){
        this.sname = sname;
    }
    public void setLevel (int level){
        this.level = level;
    }

    //addCourse
    public void addCourse(Course c){
        courses.add (c);
    }

    //removeCourse
    public void removeCourse(Course c){
        courses.remove (c);
    }

    //calcGPA
    public double calculateGPA(){
        int gpaPoints = 0;


        for(int index =0 ; index < courses.size(); index++){
            System.out.println(courses.get(index));

            Course  c = courses.get(index);
            double grade = c.getGrade();
            if(grade >= 90 ){
                gpaPoints += 4;
            }
            if(grade < 90 && grade>= 80){
                gpaPoints += 3;
            }
            if(grade < 80 && grade>= 75){
                gpaPoints += 2;
            }
            if(grade < 75 && grade>= 70){
                gpaPoints += 1;
            }
            else{
                gpaPoints += 0;
            }
        }      
          return (double) gpaPoints;  
    }

    //getBestClass

    //toString
    public String toString(){
        return "sname\n+level\n+gpaPoints";
    }

}
