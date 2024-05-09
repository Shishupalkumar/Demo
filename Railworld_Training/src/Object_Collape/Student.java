package Object_Collape;
public class Student{
    private String name;
    private Subject subject;
    private School school;

    public Student(){
    }

    public Student(String name, Subject subject, School school) {
        this.name = name;
        this.subject = subject;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }


    public void setSubject(Subject subject) {
        this.subject= subject;
    }
    public School getSchool() {
        return school;
    }


    public void setSchool(School  school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", Subject=" + subject +
                ", School=" + school +
                '}';
    }
}

