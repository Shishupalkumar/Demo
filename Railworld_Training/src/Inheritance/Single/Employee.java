package Inheritance;

public class Employee extends Address{

    //Employee employee =new Employee();

    @Override
    public void showAddress(){
        super.showAddress();
        System.out.println("class Employee is used ");
    }
}
