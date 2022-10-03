import java.io.Serializable;

public class Student implements Serializable {
    //instance variables
    private String name;
    private int level;
    private ArrayList <Course> courses;

    //constructors
    public Student (String name, int level){
        this.name = name;
        this.level = level;
        courses = new ArrayList<>();
    }

    //getters
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public ArrayList <Course>(){

    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setLevel (int level){
        this.level = level;
    }

    //addCourse
    

    //removeCourse


}
