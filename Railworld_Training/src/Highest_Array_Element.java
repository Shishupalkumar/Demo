import java.util.Arrays;
import java.util.Scanner;

public class Highest_Array_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        int max = array[size - 1];
        int secondMax = array[size - 1];

        for (int i = size - 2; i >= 0; i--) {
            if (array[i] < max) {
                secondMax = array[i];
                break;
            }
        }

        System.out.println("The second highest element in the array is: " + secondMax);

        System.out.println("The remaining elements :");
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] != secondMax) {
                System.out.println(array[i]);
            }
        }
    }
}