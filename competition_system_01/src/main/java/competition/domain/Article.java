package competition.domain;

import java.sql.Blob;
import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Article {
	public static final int IS_ARTICLE = 1;
	public static final int IS_NOT_ARTICLE = 0;
	public static final int IS_NOT_MODIFY = 0;
	public static final int IS_SHARE = 1;
	public static final int IS_NOT_SHARE = 0;
	public static final int IS_HIDDEN = 1;
	public static final int IS_NOT_HIDDEN = 0;
	
	private int articleId;
	@NotEmpty @Length(min = 1, message="Title 3 ~ ")
	private String title;
	@NotEmpty
	private byte[] content;
	private Timestamp writtenDate;
	private int hit;
	private String writerId;
	private int boardCodeId;
	private int isNotice;
	private Timestamp startPeriod;
	private Timestamp endPeriod;
	private int commentCount;
	private String password;
	private Timestamp fileLimitDate;
	private int isFile;
	private int isShare;
	
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
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

	public int getIsNotice() {
		return isNotice;
	}

	public void setIsNotice(int isNotice) {
		this.isNotice = isNotice;
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
		if(password == null || password.equals(""))
			return ;
		this.password = password;
	}

	public Timestamp getFileLimitDate() {
		return fileLimitDate;
	}

	public void setFileLimitDate(Timestamp fileLimitDate) {
		this.fileLimitDate = fileLimitDate;
	}

	public int getIsFile() {
		return isFile;
	}

	public void setIsFile(int isFile) {
		this.isFile = isFile;
	}

	public int getIsShare() {
		return isShare;
	}

	public void setIsShare(int isShare) {
		this.isShare = isShare;
	}
}
