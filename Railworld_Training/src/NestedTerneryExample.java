public class NestedTerneryExample {
    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;
        int result;

        // Nested ternary operation
        result = a > b ? (a > c ? a : c) : (b > c ? b : c);

        System.out.println("The largest number is " + result);
    }
}
