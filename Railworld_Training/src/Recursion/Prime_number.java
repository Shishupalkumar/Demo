package Recursion;

import java.util.*;
public class Prime_number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (isPrime(number, number / 2)) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }

        scanner.close();
    }

    // Recursive method to check if a number is prime
    public static boolean isPrime(int n, int divisor) {
        if (n <= 1) {
            return false; // 0 and 1 are not prime
        } else if (divisor == 1) {
            return true; // Base case: if divisor reaches 1, the number is prime
        } else {
            if (n % divisor == 0) {
                return false; // If n is divisible by divisor, it's not prime
            } else {
                return isPrime(n, divisor - 1); // Recursively check with the next divisor
            }
        }
    }
}
