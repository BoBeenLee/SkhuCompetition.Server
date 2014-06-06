package competition.domain;

public class Auth {
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
