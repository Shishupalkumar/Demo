package Date_Time;

public class String_$_2000 {
    public static void main(String[] args)
    {
        String str = "$2000";

        // Extract the numeric part of the string
        //String numericPart = str.substring(1);
        String numericPart=str.replace("$","");
        int value = Integer.parseInt(numericPart);
        value++;

        // Form the new string
        String newStr = "$" + value;

        System.out.println("Original string: " + str);
        System.out.println("After increment: " + newStr);
    }
}
