package Recursion;
import java.util.Scanner;

public class Fibonacci_Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of terms in the Fibonacci series
        System.out.print("Enter the number of terms in the Fibonacci series: ");
        int numTerms = scanner.nextInt();

        System.out.println("Fibonacci series:");
        for (int i = 0; i < numTerms; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        scanner.close();
    }

    // Recursive method to generate Fibonacci series
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case: Fibonacci of 0 is 0
        } else if (n == 1) {
            return 1; // Base case: Fibonacci of 1 is 1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call to generate Fibonacci series
        }
    }
}
