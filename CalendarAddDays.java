/**
 * Created by yizhiw on 8/4/2017.
 */
import java.util.*;

public class CalendarAddDays {
    // lookup table for common year and leap year
    int[] commonYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] leapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // utility function to get the current days, counting from the first day of the passing in year
    public int getCurrentDays(int day, int month, int year) {
        int[] y = (year % 4 == 0) ? leapYear : commonYear;
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += y[i];
        }

        days += day;

        return days;
    }

    // based on the current year and target days away from, return the final date string
    public String getDate(int year, int days) {
        int[] y = null;
        int month = 0;
        int day = 0;

        int d = 0;
        while(d < days) {
            y = (year % 4 == 0) ? leapYear : commonYear;
            if (month < 12) {
                d += y[month];
                month++;
            } else {
                year++;
                month = 0;
            }
        }

        day += days - (d - y[month - 1]);

        return (new String(month + "/" + day + "/" + year));
    }

    // add days into input date, return the final date
    public String addDays(String mdy, int addDays) {
        String[] strs = mdy.split("/");

        int month = Integer.parseInt(strs[0]);
        int day = Integer.parseInt(strs[1]);
        int year = Integer.parseInt(strs[2]);

        //System.out.println("Month: " + month + ", day: " + day + ", year :" + year);
        //System.out.println("add days:" + addDays);

        int curDays = getCurrentDays(day, month, year);
        //System.out.println("current days: " + curDays);
        int targetDays = curDays + addDays;
        //System.out.println("target days: " + targetDays);

        return getDate(year, targetDays);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the starting dates in format of mm/dd/yyyy");
        String date = sc.nextLine();
        System.out.println("Please input the add days");
        int addDays = sc.nextInt();

        CalendarAddDays obj = new CalendarAddDays();
        System.out.println(obj.addDays(date, addDays));
    }
}
