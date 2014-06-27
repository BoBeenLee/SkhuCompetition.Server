package competition.domain.list;

import java.util.List;

import competition.domain.view.MailView;

public class MailList {
	private List<MailView> mails;

	public MailList() {
		super();
	}
	
	public List<MailView> getMails() {
		return mails;
	}

	public void setMails(List<MailView> mails) {
		this.mails = mails;
	}
}
