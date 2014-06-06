package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getTimestampToString(Timestamp timestamp){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(timestamp == null)
			return "";		
		Date date = new Date(timestamp.getTime());
		return format.format(date);
	}
	
	public static Timestamp getStringToTimestamp(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		if(string == null)
			return null;
		Date date = format.parse(string);

		return new Timestamp(date.getTime());
	}
}
