package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Score;
import competition.domain.code.ScoreCode;
import competition.domain.view.ScoreView;
import competition.domain.view.code.ScoreCodeView;
import competition.mapper.ScoreMapper;
import competition.service.ScoreService;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
	@Autowired(required=false)
	ScoreMapper scoreMapper;
	
	public boolean addScoreCode(ScoreCode ScoreCode) {
		boolean isScoreCode = (1 == scoreMapper.addScoreCode(ScoreCode))? true : false;
		return isScoreCode;
	}

	public boolean removeScoreCode(int scoreCodeId) {
		boolean isScoreCode = (1 == scoreMapper.removeScoreCode(scoreCodeId))? true : false;
		return isScoreCode;
	}

	public boolean modifyScoreCode(ScoreCode ScoreCode) {
		boolean isScoreCode = (1 == scoreMapper.modifyScoreCode(ScoreCode))? true : false;
		return isScoreCode;
	}

	public ScoreCodeView getScoreCode(int scoreCodeId) {
		ScoreCodeView scoreCode = scoreMapper.getScoreCode(scoreCodeId);
		return scoreCode;
	}

	public List<ScoreCodeView> findScoreCodes(int boardCodeId) {
		List<ScoreCodeView> scoreCodeList = scoreMapper.findScoreCodes(boardCodeId);
		return scoreCodeList;
	}

	public boolean addScore(Score score) {
		boolean isScore = (1 == scoreMapper.addScore(score))? true : false;
		return isScore;
	}

	public boolean removeScore(int scoreId) {
		boolean isScore = (1 == scoreMapper.removeScore(scoreId))? true : false;
		return isScore;
	}
	
	public boolean removeScores(int articleId) {
		boolean isScore = (1 == scoreMapper.removeScores(articleId))? true : false;
		return isScore;
	}

	public boolean modifyScore(Score Score) {
		boolean isScore = (1 == scoreMapper.modifyScore(Score))? true : false;
		return isScore;
	}

	public ScoreView getScore(int scoreId) {
		ScoreView score = scoreMapper.getScore(scoreId);
		return score;
	}

	public List<ScoreView> findScores(int boardCodeId, int teamCodeId) {
		List<ScoreView> scoreList = scoreMapper.findScores(boardCodeId, teamCodeId);
		return scoreList;
	}
}
