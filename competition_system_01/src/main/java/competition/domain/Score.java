package competition.domain;

public class Score {
	private int scoreId;
	private double score;
	private int articleId;
	private int teamCodeId;
	private String userId;
	private String valuerId;
	
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getTeamCodeId() {
		return teamCodeId;
	}
	public void setTeamCodeId(int teamCodeId) {
		this.teamCodeId = teamCodeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getValuerId() {
		return valuerId;
	}
	public void setValuerId(String valuerId) {
		this.valuerId = valuerId;
	}
}
