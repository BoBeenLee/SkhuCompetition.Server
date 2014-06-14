package competition.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Article;
import competition.domain.Page;
import competition.domain.Pagination;
import competition.domain.QA;
import competition.domain.Valuer;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.QAView;
import competition.domain.view.code.BoardCodeView;
import competition.mapper.ArticleMapper;
import competition.service.ArticleService;
import competition.service.ValuerService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired(required=false)
	ArticleMapper articleMapper;
	@Autowired(required=false)
	ValuerService valuerService;
	
	
	public boolean addBoardCode(BoardCode boardCode) {
		Valuer valuer = new Valuer();
		boolean isBoardCode = (1 == articleMapper.addBoardCode(boardCode))? true : false;
		valuer.setBoardCodeId(boardCode.getBoardCodeId());
		valuer.setUserId(boardCode.getBuilderId());
		boolean isValuer = (valuerService.addValuer(valuer))? true : false;
		return isBoardCode && isValuer;
	}

	public boolean modifyBoardCode(BoardCode boardCode) {
		boolean isBoardCode = (1 == articleMapper.modifyBoardCode(boardCode))? true : false;		
		return isBoardCode;
	}
	
	public boolean removeBoard(int boardCodeId) {
		boolean isBoardCode = (1 == articleMapper.removeBoard(boardCodeId))? true : false;		
		return isBoardCode;
	}
	
	public List<BoardCodeView> getAllBoardCodes() {
		List<BoardCodeView> boardCodeList = articleMapper.getAllBoardCodes();
		return boardCodeList;
	}

	public BoardCodeView getBoard(int boardCodeId) {
		BoardCodeView bc = articleMapper.getBoard(boardCodeId);
		return bc;
	}

	public List<BoardCodeView> findBoards(String builderId, int parentBoardCodeId) {
		List<BoardCodeView> bcList = articleMapper.findBoards(builderId, parentBoardCodeId);		
		return bcList;
	}
	
	public String getBoardName(int boardCodeId) {
		return articleMapper.getBoardName(boardCodeId);
	}
	
	public boolean addArticle(Article article) {
		boolean isArticle = (1 == articleMapper.addArticle(article))? true : false;		
		return isArticle;
	}

	public boolean modifyArticle(Article article) {
		boolean isArticle = (1 == articleMapper.modifyArticle(article))? true : false;
		return isArticle;
	}

	public boolean removeArticle(int articleId) {
		boolean isArticle = (1 == articleMapper.removeArticle(articleId))? true : false;		
		return isArticle;
	}

	public ArticleView getArticle(int articleId) {
		ArticleView av = articleMapper.getArticle(articleId);		
		return av;
	}
	
	public List<ArticleView> findArticles(Pagination pagination){
		List<ArticleView> avList = articleMapper.findArticles(pagination); 
		return avList;
	}

	public List<ArticleView> findNotices(Pagination pagination) {
		List<ArticleView> avList = articleMapper.findNotices(pagination); 
		return avList;
	}

	public int getTotalArticles(Pagination pagination) {
		int totalArticleCount = articleMapper.getTotalArticles(pagination);
		return totalArticleCount;
	}
	
	public List<Page> getPageList(int parentBoardId) {
		List<BoardCodeView> bcList = findBoards(null,
				parentBoardId);

		ArrayList<Page> pgList = new ArrayList<Page>();

		for (BoardCodeView bc : bcList)
			pgList.add(new Page(bc.getBoardName(), "sub/board.do?bid="
					+ bc.getBoardCodeId()));
		return pgList;
	}
	
	
	public boolean addQA(QA qa) {
		boolean isQA = (1 == articleMapper.addQA(qa))? true : false;		
		return isQA;
	}

	public boolean modifyQA(QA qa) {
		boolean isQA = (1 == articleMapper.modifyQA(qa))? true : false;		
		return isQA;
	}

	public QAView getQA(int articleId) {
		QAView qv = articleMapper.getQA(articleId);
		return qv;
	}

	public List<QAView> findQAs(Pagination pagination) {
		List<QAView> qvList = articleMapper.findQAs(pagination);
		return qvList;
	}

	public boolean increaseHit(int articleId) {
		boolean isHit = false;
		ArticleView article = getArticle(articleId);
		article.setHit(article.getHit() + 1);
		
		isHit = this.modifyArticle(article);
		return isHit;
	}

	public boolean updownCommentCount(int articleId, boolean isCommentCount) {
		boolean isHit = false;
		ArticleView article = getArticle(articleId);
		if(isCommentCount)
			article.setCommentCount(article.getCommentCount() + 1);
		else
			article.setCommentCount(article.getCommentCount() - 1);
		isHit = this.modifyArticle(article);
		return isHit;
	}
}
