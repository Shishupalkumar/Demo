package Object_Collape;
public class School{
    private String name;
    //private Subject subject;

    public School(){
    }

    public School(String name) {
        this.name = name;

    }

    public String getSchool() {
        return name;
    }

    public void setSchool(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +

                '}';
    }
}

