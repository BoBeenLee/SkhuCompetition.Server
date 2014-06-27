package competition.domain;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.internal.NotNull;

public class User {
	@NotEmpty @Length(min = 3, max = 20, message = "UserId 3 ~ 20")
	private String userId;
	private int authId;
	@NotEmpty
	private String userName;
	@NotEmpty @Length(min = 3, max = 20, message = "Password 3 ~ 20")
	private String userPW;
	@NotEmpty
	private String userTel;
	@NotEmpty @Email(message = "Invalid Email")
	private String userEmail;
	@NotEmpty
	private String question;
	@NotEmpty
	private String answer;
	
	private int grade;
	@NotEmpty
	private String department;
	private Timestamp createdDate;
	private int preAuthId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPW() {
		return userPW;
	}
	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public int getPreAuthId() {
		return preAuthId;
	}
	public void setPreAuthId(int preAuthId) {
		this.preAuthId = preAuthId;
	}
	
}
