public class Funtion_UserDefined {

    // User-defined method to calculate factorial
    public static long factorial(int number)
    {
        long result = 1;
        for (int factor = 2; factor <= number; factor++)
        {
            result *= factor;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int number = 5; // Example number
        long factorial = factorial(number);
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
