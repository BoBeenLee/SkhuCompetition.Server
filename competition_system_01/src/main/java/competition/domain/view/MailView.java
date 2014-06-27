package competition.domain.view;

import competition.domain.Mail;

public class MailView extends Mail {
	private String toId;
	private String toName;
	private String toAuthName;
	private String fromId;
	private String fromName;
	private String fromAuthName;

	public String getToId() {
		return toId;
	}
	public void setToId(String toId) {
		this.toId = toId;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getToAuthName() {
		return toAuthName;
	}
	public void setToAuthName(String toAuthName) {
		this.toAuthName = toAuthName;
	}
	public String getFromId() {
		return fromId;
	}
	public void setFromId(String fromId) {
		this.fromId = fromId;
	}
	public String getFromAuthName() {
		return fromAuthName;
	}
	public void setFromAuthName(String fromAuthName) {
		this.fromAuthName = fromAuthName;
	}
}
