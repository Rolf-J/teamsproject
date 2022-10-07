import java.io.Serializable;

public class Teacher implements Serializable {
    
    //Instance
    private String tname;
    private int experience;

    //Constructor
    public Teacher (String tname, int experience){
        this.tname = tname;
        this.experience = experience;
    }

    //getters
    public String getTname(){
        return tname;
    }
    public int getExperience(){
        return experience;
    }

    //setters
    public void setTname(String tname){
        this.tname = tname;
    }
    public void setExperience (int experience){
        this.experience = experience;
    }

    //to string
    public String toString(){
        return tname;
    }
}
