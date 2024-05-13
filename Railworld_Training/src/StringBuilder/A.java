package StringBuilder;

public class A {
    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder("Hello");
        String s="Hello";

        System.out.println(s.equals(sb));
        System.out.println("The Reverse of String Builder :"+sb.reverse());
        System.out.println("The Capacity of String Builder: "+sb.capacity());



    }
}
