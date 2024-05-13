import java.util.Scanner;

public class Matrix {

    public static void main(String a[]) {

        // Arrays.toString(); method is used to print array without using for loop

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = sc.nextInt();

        // Create a 2D array
        int[][] matrix = new int[rows][columns];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }

        // Print the entered matrix
        System.out.println("Entered matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

            }
        }

    }
}


