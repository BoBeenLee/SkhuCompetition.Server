package competition.domain.code;

public class ScoreCode {
	private int scoreCodeId;
	private int boardCodeId;
	private String scoreName;
	private String content;
	private int rank;
	private int teamCodeId;
	
	public int getScoreCodeId() {
		return scoreCodeId;
	}
	public void setScoreCodeId(int scoreCodeId) {
		this.scoreCodeId = scoreCodeId;
	}
	public int getBoardCodeId() {
		return boardCodeId;
	}
	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTeamCodeId() {
		return teamCodeId;
	}
	public void setTeamCodeId(int teamCodeId) {
		this.teamCodeId = teamCodeId;
	}
}
