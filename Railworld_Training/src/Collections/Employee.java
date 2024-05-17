package Collections;

public class Employee {
    private int eId;
    private String name;
    private String position;

    public Employee(int eId, String name, String position) {
        this.eId = eId;
        this.name=name;
        this.position=position;
    }

    public Employee(String name) {
        this.name=name;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
