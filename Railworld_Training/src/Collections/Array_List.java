package Collections;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Array_List {
    public static void main(String[] args) {

       ArrayList arrayList =new ArrayList();
       /*
        arrayList.add("Hello");
        arrayList.add(12);
        arrayList.add('H');
        System.out.println(arrayList);

        ArrayList<Integer>arrayList1=new ArrayList<>();
        arrayList1.add(12);
        arrayList1.add(23);
        arrayList1.add(25);
        System.out.println(arrayList1);
        */

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the employee Details");
        Employee employee = new Employee(sc.nextInt(), sc.nextLine(), sc.nextLine());
        Employee employee1 = new Employee(sc.nextInt(), sc.nextLine(), sc.nextLine());
      //  Employee employee1=new Employee(11,"hkjhjk","ghjhg");
        arrayList.add(employee);
        arrayList.add(employee1);
       // System.out.println(arrayList);

        //Collections.sort(arrayList,new EmployeeById());
        //System.out.println(arrayList1);


        //List<Employee> employees = new ArrayList<>();
        //employees.add(new Employee("John"));
        //employees.add(new Employee("Alice"));
       // employees.add(new Employee("Bob"));

        // Sort employees by name using the EmployeeByNameComparator
        Collections.sort(arrayList, new Employee_by_name());
        System.out.println(arrayList);

        // Print the sorted list of employees
        /*for (Employee Employee : employee) {
            System.out.println(employee.getName());
        }
        */

    }
}
