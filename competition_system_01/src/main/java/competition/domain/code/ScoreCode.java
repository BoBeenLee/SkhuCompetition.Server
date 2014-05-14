package competition.domain.code;

public class ScoreCode {
	private int scoreCodeId;
	private int boardCodeId;
	private String scoreName;
	private String content;
	
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
}
