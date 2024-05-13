import java.util.Scanner;

public class Anti2_Diagonal {
    public static void main(String a[]) {
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
        System.out.println("Display matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(i==j || i+j!=rows)
                    System.out.print(matrix[i][j] +" ");

                if(i+j==rows-1)
                    System.out.print(  " ");

            }
            System.out.println();

        }


    }
}


