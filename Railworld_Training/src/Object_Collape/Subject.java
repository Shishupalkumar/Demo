package Object_Collape;

public class Subject {
    private String Physics;
    private String chemistry;
    private String Biology;


    public Subject(String Physics, String chemistry, String Biology) {
        this.Physics = Physics;
        this.chemistry = chemistry;
        this.Biology = Biology;

    }

    public Subject() {
    }

    public String getPhysics() {
        return Physics;
    }

    public void setPhysics(String Physics) {
        this.Physics = Physics;
    }

    public String getchemistry() {
        return chemistry;
    }

    public void setchemistry(String chemistry) {
        this.chemistry = chemistry;
    }

    public String getBiology() {
        return Biology;
    }

    public void setBiology(String Biology) {
        this.Biology = Biology;
    }



    @Override
    public String toString() {
        return "Subject{" +
                "Subject 1='" + Physics+ '\'' +
                ", Subject 2='" + chemistry + '\'' +
                ", Subject 3='" + Biology+ '\'' +

                '}';
    }
}

