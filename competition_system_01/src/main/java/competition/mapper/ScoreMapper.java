package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Score;
import competition.domain.code.ScoreCode;
import competition.domain.view.ScoreView;
import competition.domain.view.code.ScoreCodeView;

public interface ScoreMapper {
	// ScoreCode
	public int addScoreCode(ScoreCode scoreCode);
	public int removeScoreCode(int scoreCodeId);
	public int modifyScoreCode(ScoreCode scoreCode);
	public ScoreCodeView getScoreCode(int scoreCodeId);
	public List<ScoreCodeView> findScoreCodes(int boardCodeId);

	// Score
	public int addScore(Score score);
	public int removeScore(int scoreId);
	public int removeScores(int articleId);
	public int modifyScore(Score score);
	public ScoreView getScore(int scoreId);
	public List<ScoreView> findScores(@Param("boardCodeId") int boardCodeId, @Param("teamCodeId") int teamCodeId);
}
