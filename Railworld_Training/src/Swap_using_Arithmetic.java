
import java.util.Scanner;
import java.util.Scanner.*;
public class Swap_using_Arithmetic {
    public static void main(String a[]){
        Scanner sc =new Scanner(System.in);

        System.out.println("Enter the number 1: ");
        int num1=sc.nextInt();

        System.out.println("Enter the number 1: ");
        int num2=sc.nextInt();
        System.out.println(" number before swap ");
        System.out.println(" num1 ="+ num1);
        System.out.println("num2= "+num2);

        num1=num1+num2;
        num2=num1-num2;
        num1=num1-num2;
        System.out.println(" number After swap ");
        System.out.println("num1 ="+num1);
        System.out.println("num2= "+num2);


    }
}
