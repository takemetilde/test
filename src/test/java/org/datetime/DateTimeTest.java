package org.datetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeTest {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    LocalDateTime now = LocalDateTime.now();

    SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

    @Test
    public void test() throws ParseException {
        System.out.println(dtf.format(now));
        System.out.println(System.getProperty("user.dir")+"/target/"+dtf.format(now)+".jpg");

        Date date = sdf.parse("May 13, 1987");
        System.out.println(date);
        getDate("May 13, 1987");

    }

    private void getDate(String dateString) throws ParseException{
        Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(dateString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        String month = new SimpleDateFormat("MMMM").format(cal.getTime());
        String day = new SimpleDateFormat("d").format(cal.getTime());
        String year = new SimpleDateFormat("yyyy").format(cal.getTime());

        System.out.println(month);
        System.out.println(day);
        System.out.println(year);
    }
}
