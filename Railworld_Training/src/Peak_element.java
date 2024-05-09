
import java.util.Scanner;
//import java.util.Scanner;
public class Peak_element {
    public static void main(String a[])
    {
        System.out.println("Enter the size of Array: ");
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];//declaration
        System.out.println("Enter the Array element: ");
        for (int i = 0; i < arr.length; i++)//initialization
        {

            arr[i] = sc.nextInt();
        }
//        for(int i:a)//to show stored array
//        {
////            System.out.println(i);
//
//        }
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                System.out.println("The Peak Element is: "+arr[i]);
                break;
            }
        }
    }
}
