package competition.domain.list;

import java.util.List;

import competition.domain.view.code.ScoreCodeView;

public class ScoreCodeList {
	private List<ScoreCodeView> scoreCodes;
	private int boardCodeId;
	
	public ScoreCodeList() {
		super();
	}
	
	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public List<ScoreCodeView> getScoreCodes() {
		return scoreCodes;
	}

	public void setScoreCodes(List<ScoreCodeView> scoreCodes) {
		this.scoreCodes = scoreCodes;
	}
}
