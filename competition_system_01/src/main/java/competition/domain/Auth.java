package competition.domain;

public class Auth {
	public final static String ROLE_ADMIN = "ROLE_ADMIN";
	public final static String ROLE_PROFESOR = "ROLE_PROFESOR";
	public final static String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";
	public final static String ROLE_STUDENT = "ROLE_STUDENT";
	public final static String ROLE_USER = "ROLE_USER";
	
	private int authId;
	private String authName;
	private String groupPW;
	
	public int getAuthId() {
		return authId;
	}
	public void setAuthId(int authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getGroupPW() {
		return groupPW;
	}
	public void setGroupPW(String groupPW) {
		this.groupPW = groupPW;
	}
}
