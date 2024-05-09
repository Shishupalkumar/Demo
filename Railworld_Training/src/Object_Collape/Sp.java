package Object_Collape;

import Object_Collape.Student;
import Object_Collape.Subject;

import java.util.Scanner;

public class Sp {
    public static void main(String[] args) {
        Student student =new Student();
        Subject ad=new Subject();
        School school =new School();

        System.out.println("Enter the Student name");
        Scanner sc=new Scanner(System.in);

        student.setName(sc.nextLine());
        student.setSubject(new Subject("Phy","chem","Bio"));
       // student.setName("JSM Educational Academy");
        System.out.println("Enter the School Name: ");
       school.setSchool(sc.nextLine());
        student.setSchool(school);


//        ad.setCity("raipur");
//        ad.setState("cg");
//        ad.setPin(122345);
        //System.out.println(employee.getName());
        System.out.println(student.toString());
    }
}
