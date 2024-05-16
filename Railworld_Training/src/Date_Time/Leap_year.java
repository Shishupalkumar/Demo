package Date_Time;

import java.util.Scanner;

public class Leap_year {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input a year
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        scanner.close();
    }

    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        // If year is divisible by 4
        if (year % 4 == 0) {
            // If year is divisible by 100
            if (year % 100 == 0) {
                // If year is divisible by 400
                if (year % 400 == 0) {
                    return true; // Leap year
                } else {
                    return false; // Not a leap year
                }
            } else {
                return true; // Leap year
            }
        } else {
            return false; // Not a leap year
        }
    }
}
