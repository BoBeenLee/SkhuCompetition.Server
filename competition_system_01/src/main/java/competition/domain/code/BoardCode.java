package competition.domain.code;

public class BoardCode {
	public final static int BOARDCODE_NOTICE = 1;
	public final static int BOARDCODE_COMPETITION = 2;
	public final static int BOARDCODE_DATA = 3;
	public final static int BOARDCODE_QA = 4;
	
	private int boardCodeId;	
	private String builderId;
	private String boardType;
	private String boardName;
	private int isHidden;
	private int parentBoardCodeId;
	private int listLevel;
	private int writeLevel;
	private int readLevel;
	private int commentLevel;
	private int isSecret;
	private int isReply;
	private int isComment;

	public BoardCode() {
		super();
	}
	
	public BoardCode(String builderId, String boardType, int isHidden, int parentBoardCodeId) {
		super();
		this.builderId = builderId;
		this.boardType = boardType;
		this.isHidden = isHidden;
		this.parentBoardCodeId = parentBoardCodeId;
	}
	
	public int getBoardCodeId() {
		return boardCodeId;
	}
	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}
	public String getBuilderId() {
		return builderId;
	}
	public void setBuilderId(String builderId) {
		this.builderId = builderId;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(int isHidden) {
		this.isHidden = isHidden;
	}
	public int getParentBoardCodeId() {
		return parentBoardCodeId;
	}
	public void setParentBoardCodeId(int parentBoardCodeId) {
		this.parentBoardCodeId = parentBoardCodeId;
	}
	public int getListLevel() {
		return listLevel;
	}
	public void setListLevel(int listLevel) {
		this.listLevel = listLevel;
	}
	public int getWriteLevel() {
		return writeLevel;
	}
	public void setWriteLevel(int writeLevel) {
		this.writeLevel = writeLevel;
	}
	public int getReadLevel() {
		return readLevel;
	}
	public void setReadLevel(int readLevel) {
		this.readLevel = readLevel;
	}
	public int getCommentLevel() {
		return commentLevel;
	}
	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}
	public int getIsSecret() {
		return isSecret;
	}
	public void setIsSecret(int isSecret) {
		this.isSecret = isSecret;
	}
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public int getIsComment() {
		return isComment;
	}
	public void setIsComment(int isComment) {
		this.isComment = isComment;
	}
}
