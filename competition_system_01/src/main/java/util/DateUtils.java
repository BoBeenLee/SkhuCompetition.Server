package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
	public static String getDateToString(Timestamp timestamp){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(timestamp == null)
			return "";		
		Date date = new Date(timestamp.getTime());
		return format.format(date);
	}
	
	public static Timestamp getStringToDate(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(string == null)
			return null;
		Date date = format.parse(string);

		return new Timestamp(date.getTime());
	}
	
	public static String getDateTimeToString(Timestamp timestamp){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mma", Locale.US);
		
		if(timestamp == null)
			return "";		
		Date date = new Date(timestamp.getTime());
		return format.format(date);
	}
	
	public static Timestamp getStringToDateTime(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mma", Locale.US);
		
		if(string == null)
			return null;
		Date date = format.parse(string);

		return new Timestamp(date.getTime());
	}
}
