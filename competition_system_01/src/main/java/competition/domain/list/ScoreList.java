package competition.domain.list;

import java.util.List;

import competition.domain.view.ScoreView;

public class ScoreList {
	List<ScoreView> scores;
	int boardCodeId;
	int teamCodeId;

	public List<ScoreView> getScores() {
		return scores;
	}

	public void setScores(List<ScoreView> scores) {
		this.scores = scores;
	}

	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public int getTeamCodeId() {
		return teamCodeId;
	}

	public void setTeamCodeId(int teamCodeId) {
		this.teamCodeId = teamCodeId;
	}
}
