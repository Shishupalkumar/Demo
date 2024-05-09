import java.util.Arrays;

public class Sort_Elements {
    public static void main(String[] args) {
        int[] array = {0, 0, 0, 1, 2, 2, 1};
        System.out.print("The Unsorted array is: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            // Print a comma and space if it's not the last element
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sortArray(int[] arr) {
        int[] count = new int[3]; // Considering values from 0 to 2

        // Count the occurrences of each element
        for (int num : arr) {
            count[num]++;
        }

        // Overwrite the original array with sorted values
        int index = 0;
        for (int i = 2; i >= 0; i--) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
}
