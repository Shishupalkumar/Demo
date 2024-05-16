package Date_Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
class User_defined_format
{
    public static void main(String args[])
    {
        DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time in default format: "+ current);
        String udf= current.format(formatObj);
        System.out.println("current date and time in userdefined format: "+ udf);
    }
}
