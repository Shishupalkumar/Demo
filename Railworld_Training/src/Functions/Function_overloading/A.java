package Functions.Function_overloading;

public class A {
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method with three int parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method with two double parameters
    public double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        A a = new A();

        // Calling the add method with different parameter lists
        System.out.println("Sum of 10 and 20: " + a.add(10, 20));         // Calls the first add method
        System.out.println("Sum of 10, 20 and 30: " + a.add(10, 20, 30)); // Calls the second add method
        System.out.println("Sum of 10.5 and 20.5: " + a.add(10.5, 20.5)); // Calls the third add method
    }
}
