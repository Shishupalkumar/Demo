import java.util.Scanner;

public class AntiDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the square matrix
        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        // Create a square 2D array
        int[][] matrix = new int[size][size];

        // Input the elements of the matrix
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Enter element at position [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print the anti-diagonal elements with tabs for non-anti-diagonal elements
        System.out.println("Anti-Diagonal:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i + j == size - 1) {
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
