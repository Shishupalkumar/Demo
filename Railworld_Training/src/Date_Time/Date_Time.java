package Date_Time;

import java.time.*;
//import java.time.*;
        //chrono.ChronoLocalDate;

public class Date_Time {
    public static void main(String args[]){
// the current date (yyyy-MM-dd) format
        LocalDate date = LocalDate.now();
        System.out.println("the current date is :"+ date);
// the current time hh:mm:ss.nanosec

        LocalTime time = LocalTime.now();
        System.out.println("the current time is "+ time);
// will give us the current time and date combined with "T"

        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : "+ current);

        LocalDate localdate1 =LocalDate.from(ZonedDateTime.now());
        System.out.println(localdate1);

        LocalTime localTime=LocalTime.from(ZonedDateTime.now());
        System.out.println(localTime);

        // for leap year
        System.out.println(localdate1.isLeapYear());
    }


}
