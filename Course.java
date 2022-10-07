import java.io.Serializable;

public class Course implements Serializable, Cloneable{
    //instance variables
    private String subject;
    private Teacher teacher;
    private double grade;
    private boolean current;

    //constructors
    public Course(String subject, Teacher teacher){
        this.subject=subject;
        this.teacher=teacher;
    }
    public Course(String subject, Teacher teacher, boolean current, Double grade){
        this.subject=subject;
        this.teacher=teacher;
        this.current=current;
        this.grade=grade;
    }

    //getter
    public String getSubject(){
        return subject;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    public double getGrade(){
        return grade;
    }
    public boolean getCurrent(){
        return current;
    }

    //setter
    public void setSubject(String subject){
        this.subject=subject;
    }
    public void setTeacher(Teacher teacher){
        this.teacher=teacher;
    }
    public void setGrade(double grade){
        this.grade=grade;
    }
    public void setCurrent(boolean current){
        this.current=current;
    }

    //cloneable
    public Course clone(){
        try{
            return (Course) super.clone();
        }
        catch (Exception e){
            return null;
        }
    }

    //toString: *subject* by *teacher* Grade: *grade*
    public String toString(){
        if (grade > 0){
            return subject+" by "+teacher+" Grade: "+grade;
        }
        else{
            return subject+" by "+teacher;
        }
    }
}
