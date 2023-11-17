package utils;

import java.util.Calendar;
import java.util.Date;

public class Common {

    // Compare dates to find news by interval
    public static int compareDates(Date now, Date in, int minutes) {
        Calendar minus = Calendar.getInstance();
        minus.setTime(new Date());
        minus.add(Calendar.MINUTE, - minutes);
        Calendar now_cal = Calendar.getInstance();
        now_cal.setTime(now);

        if (in.after(minus.getTime()) && in.before(now_cal.getTime())) {
            return 1;
        } else
            return 0;
    }

}
