package Recursion;

import java.util.*;
public class Disarium_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isDisarium(number)) {
            System.out.println(number + " is a Disarium number.");
        } else {
            System.out.println(number + " is not a Disarium number.");
        }

        scanner.close();
    }

    // Method to check if a number is a Disarium number
    public static boolean isDisarium(int n) {
        int originalNumber = n;
        int numDigits = countDigits(n);
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, numDigits);
            numDigits--;
            n /= 10;
        }

        return sum == originalNumber;
    }

    // Method to count the number of digits in a number
    public static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}
