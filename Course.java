import java.io.Serializable;

public class Course implements Serializable, Cloneable{
    //instance variables
    private String subject;
    private String teacher;
    private double grade;
    private boolean current;

    //constructors
    public Course(String subject, String teacher){
        this.subject=subject;
        this.teacher=teacher;
    }
    public Course(String subject, String teacher, boolean current, Double grade){
        this.subject=subject;
        this.teacher=teacher;
        this.current=current;
        this.grade=grade;
    }

    //getter
    public String getSubject(){
        return subject;
    }
    public String getTeacher(){
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
    public void setTeacher(String teacher){
        this.teacher=teacher;
    }
    public void setGrade(double grade){
        this.grade=grade;
    }
    public void setCurrent(boolean current){
        this.current=current;
    }

    //cloneable
    public class Course clone(){
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
