package competition.domain.view;

import competition.domain.User;

public class UserView extends User {
	// user에 없는 부분이지만 뷰에서 받을 때 필요.
	private String groupPW;
	private String authName;

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
