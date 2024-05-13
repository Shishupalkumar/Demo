public class String_Remove_All {

    public static void main(String[] args) {
        String str = "Hello! This is a string with special characters: @#$%^&*()";
        String Str1 = str.replaceAll("[^a-zA-Z0-9\\s]", ""); // Remove all non-alphanumeric characters except spaces

        System.out.println("Original String: " + str);
        System.out.println("String after removing special characters: " +Str1);

        StringBuilder sd=new StringBuilder("Hello");
        sd.append("Ram");

        System.out.println(sd);
        sd.setLength(15);
        System.out.println(sd.capacity());
    }
}
