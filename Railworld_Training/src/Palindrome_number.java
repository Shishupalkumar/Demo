
import java.util.Scanner;
class Palindrome_number
{
    public static void main(String args[])
    {
        int r,sum=0,temp;

        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();//It is the number variable to be checked for palindrome

        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
        }
        if(temp==sum)
            System.out.println(temp+": is palindrome number ");
        else
            System.out.println(temp+":  is not palindrome");
    }
}
