import java.util.Scanner;

public class MainDiagonalPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        // Create a 2D array
        int[][] matrix = new int[rows][columns];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print the main diagonal elements with tabs for non-diagonal elements
        System.out.println("Main Diagonal:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
