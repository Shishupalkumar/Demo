import java.util.Scanner;

public class ElectricityBillCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter units consumed: ");
        int unitsConsumed = scanner.nextInt();

        double billAmount = calculateBill(unitsConsumed);
        System.out.println("Electricity Bill: $" + billAmount);
        scanner.close();
    }

    public static double calculateBill(int units)
    {
        double billAmount = 0;
        if (units <= 100)
        {
            billAmount = units * 2;
        }
        else if (units <= 150)
        {
            billAmount = 100 * 2 + (units - 100) * 3;
        }
        else if (units <= 200)
        {
            billAmount = 100 * 2 + 50 * 3 + (units - 150) * 4;
        }
        else if (units <= 250)
        {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + (units - 200) * 5;
        }
        else if (units <= 300)
        {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + (units - 250) * 6;
        }
        else if (units <= 500)
        {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + (units - 300) * 7;
        }
        else
        {
            billAmount = 100 * 2 + 50 * 3 + 50 * 4 + 50 * 5 + 50 * 6 + 200 * 7 + (units - 500) * 8;
        }
        return billAmount;
    }
}
