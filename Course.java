import java.io.Serializable;

public class Course implements Serializable{
    //instance variables
    private String subject;
    private String teacher;
    private double grade;

    //constructors
    public Course(String subject, String teacher){
        this.subject=subject;
        this.teacher=teacher;
    }
    public Course(String subject, String teacher, Double grade){
        this.subject=subject;
        this.teacher=teacher;
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

    //setter
    public void setSubject(String subject){
        this.subject=subject;
    }
    public void getTeacher(String teacher){
        this.teacher=teacher;
    }
    public void getGrade(double grade){
        this.grade=grade;
    }

    //toString: *subject* by *teacher* Grade: *grade*
    public String toString(){
        if gradeset{
            return subject+" by "+teacher+" Grade: "+grade;
        }
        else{
            return subject+" by "+teacher;
        }
    }
}
