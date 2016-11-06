package week11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAndCalExample {
	
	static DateFormat dateformatter = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z"); 


	public static void main(String[] args) {

		// what is date

		long ts = System.currentTimeMillis();
		System.out.println(ts);
		
		Date now = new Date();
		System.out.println(now);
		System.out.println(dateformatter.format(now));

		System.out.println();
		
		// what is calendar
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
	
		cal.setTimeZone(TimeZone.getTimeZone("UTC"));
		System.out.println(cal.getTime());
		System.out.println(dateformatter.format(cal.getTime()));
		
		System.out.println();
		
		// what is timezone
		// set timezone on formatter / calendar.

		Date today = new Date();
		dateformatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	
		System.out.println(dateformatter.format(today));
		
		// why use either?
		// how to format?
		
		
		
	}

}
