package competition.domain.view.code;

import competition.domain.code.ScoreCode;

public class ScoreCodeView extends ScoreCode {
	private String teamName;	
	private int sum;
	
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
