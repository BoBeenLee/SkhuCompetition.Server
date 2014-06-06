package competition.domain.code;

public class BoardCode {
	private int boardCodeId;	
	private String builderId;
	private String boardType;
	private String boardName;
	private int isHidden;
	private int parentBoardCodeId;
	
	
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
	
}
