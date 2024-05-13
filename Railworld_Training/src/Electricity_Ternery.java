
import java.util.Scanner;
public class Electricity_Ternery {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Unit consumed: ");
        int unitsConsumed = sc.nextInt();
        double billAmount = calculateBill(unitsConsumed);
        System.out.println("Electricity Bill: $" + billAmount);
    }

    public static double calculateBill(int units) {
        return units <= 100 ? units * 2 :
                units <= 150 ? 100 * 2 + (units - 100) * 3 :
                        units <= 200 ? 100 * 2 + 50 * 3 + (units - 150) * 4 :
                                units <= 250 ? 100 * 2 + 50 * 3 + 50 * 4 + (units - 200) * 5 :
                                        units <= 300 ? 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + (units - 250) * 6 :
                                                units <= 500 ? 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + (units - 300) * 7 :
                                                        100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + 200 * 7 + (units - 500) * 8;
    }
}
