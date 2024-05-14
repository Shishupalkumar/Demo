package Interface.Comparable;
import java.util.Scanner;
public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks of two students
        System.out.print("Enter marks of first student: ");
        int marks1 = scanner.nextInt();

        System.out.print("Enter marks of second student: ");
        int marks2 = scanner.nextInt();

        // Create Student objects
        A student1 = new A(marks1);
        A student2 = new A(marks2);

        // Compare the marks
        int comparisonResult = student1.compareTo(student2);

        if (comparisonResult > 0) {
            System.out.println("Marks of first student are higher.");
        } else if (comparisonResult < 0) {
            System.out.println("Marks of second student are higher.");
        } else {
            System.out.println("Marks of both students are equal.");
        }

        scanner.close();
    }
}

