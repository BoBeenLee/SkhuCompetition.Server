package competition.domain.log;

import java.sql.Timestamp;


public class Log {
	private int logId;
	private String ip;
	private String userId;
	private Timestamp enterDate;
	
	public Log() {
		super();
	}
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Timestamp enterDate) {
		this.enterDate = enterDate;
	}
}
