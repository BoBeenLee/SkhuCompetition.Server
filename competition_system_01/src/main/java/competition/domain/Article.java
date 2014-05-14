package competition.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Article {
	private int aritcleId;
	private String title;
	private Blob content;
	private Timestamp writtenDate;
	private int hit;
	private String writerId;
	private int boardCodeId;
	private int notice;
	private Timestamp startPeriod;
	private Timestamp endPeriod;
	private int commentCount;
	private String password;
	private int articleHidden;

	public int getAritcleId() {
		return aritcleId;
	}

	public void setAritcleId(int aritcleId) {
		this.aritcleId = aritcleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public Timestamp getWrittenDate() {
		return writtenDate;
	}

	public void setWrittenDate(Timestamp writtenDate) {
		this.writtenDate = writtenDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	public Timestamp getStartPeriod() {
		return startPeriod;
	}

	public void setStartPeriod(Timestamp startPeriod) {
		this.startPeriod = startPeriod;
	}

	public Timestamp getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(Timestamp endPeriod) {
		this.endPeriod = endPeriod;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getArticleHidden() {
		return articleHidden;
	}

	public void setArticleHidden(int articleHidden) {
		this.articleHidden = articleHidden;
	}
}
