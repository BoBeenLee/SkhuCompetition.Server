package competition.domain.view;

import competition.domain.User;

public class UserView extends User {
	private String AuthName;

	public String getAuthName() {
		return AuthName;
	}

	public void setAuthName(String authName) {
		AuthName = authName;
	}
}
