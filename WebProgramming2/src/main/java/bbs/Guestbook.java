package bbs;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Guestbook {
	private int _id;
	private String _text;
	private String _name;
	private String _passwd;
	private String _ip;
	private Timestamp _date;

	static private SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	static private SimpleDateFormat format2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public int getId() {
		return _id;
	}

	public String getText() {
		return _text;
	}

	public String getName() {
		return _name;
	}

	public String getPasswd() {
		return _passwd;
	}

	public String getIP() {
		return _ip;
	}

	public Timestamp getDate() {
		return _date;
	}

	public void setId(int id) {
		_id = id;
	}

	public void setText(String text) {
		_text = text;
	}

	public void setName(String name) {
		_name = name;
	}

	public void setPasswd(String passwd) {
		_passwd = passwd;
	}

	public void setIP(String ip) {
		_ip = ip;
	}

	public void setDate(Timestamp date) {
		_date = date;
	}

	public String getDateShort() {
		return format1.format(_date);
	}

	public String getDateLong() {
		return format2.format(_date);
	}
}
