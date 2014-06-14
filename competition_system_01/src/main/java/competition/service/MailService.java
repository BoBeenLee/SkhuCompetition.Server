package competition.service;

import org.apache.ibatis.annotations.Param;

import competition.domain.view.MailView;

public interface MailService {
	public MailView getEmail(String userId, String question, String answer);
	public void sendMail(String to, String subject, String body);
	public void sendPreConfiguredMail(String message);
}
