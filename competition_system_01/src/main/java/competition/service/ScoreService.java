package competition.service;

import java.util.List;

import competition.domain.Score;
import competition.domain.code.ScoreCode;
import competition.domain.view.ScoreView;
import competition.domain.view.code.ScoreCodeView;

public interface ScoreService {

	// ScoreCode
	public boolean addScoreCode(ScoreCode ScoreCode);
	public boolean removeScoreCode(int scoreCodeId);
	public boolean modifyScoreCode(ScoreCode ScoreCode);
	public ScoreCodeView getScoreCode(int scoreCodeId);
	public List<ScoreCodeView> findScoreCodes(int boardCodeId);

	// Score
	public boolean addScore(Score Score);
	public boolean removeScore(int scoreId);
	public boolean modifyScore(Score Score);
	public ScoreView getScore(int scoreId);
	public List<ScoreView> findScores(int boardCodeId, int teamCodeId);
}
