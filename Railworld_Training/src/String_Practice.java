public class String_Practice{
    public static void main(String[] args) {

        String a=new String("Hello");
        String a1=new  String("hello");
        String s="hello";
        System.out.println(a==a1);
        System.out.println(a.equals(a1));
        System.out.println(a1.intern()==s);
        System.out.println(s.replace("e","a"));
        System.out.println(s+="Ram");
        System.out.println(s.toLowerCase());
        System.out.println(s.toUpperCase());
        System.out.println(s.concat(a));
        System.out.println(s.startsWith("h"));
    }
}
