package competition.domain;

import java.sql.Blob;
import java.sql.Timestamp;

public class Comment {
	private int commentId;
	private int articleId;
	private String writerId;
	private Blob content;
	private Timestamp writtenDate;
	private int parentCommentId;
	private int distance;
	private int step;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
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

	public int getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(int parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
