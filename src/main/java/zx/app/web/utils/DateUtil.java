package zx.app.web.utils;

import org.springframework.lang.NonNull;
import org.springframework.util.Assert;
import java.util.Calendar;
import java.util.Date;

/**
 * @author chenk
 */
public class DateUtil {
    private DateUtil() {
    }
    @NonNull
    public static Date now() {
        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return date;
    }

    public static Calendar convertTo(@NonNull Date date) {
        Assert.notNull(date, "Date must not be null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
