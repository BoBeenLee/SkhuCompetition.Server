package competition.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.Article;
import competition.domain.Page;
import competition.domain.Pagination;
import competition.domain.QA;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.QAView;
import competition.domain.view.code.BoardCodeView;

public interface ArticleService {
	public boolean addBoardCode(BoardCode boardCode);
	public boolean removeBoard(int boardCodeId);
	public boolean modifyBoardCode(BoardCode boardCode);
	public List<BoardCodeView> getAllBoardCodes();	
	public BoardCodeView getBoard(int boardCodeId, int isHidden);
	public BoardCodeView getBoard(int boardCodeId);
	public List<BoardCodeView> findBoards(String builderId, int parentBoardCodeId);
	public List<BoardCodeView> findBoards(int isHidden, String builderId, int parentBoardCodeId);
	
	public String getBoardName(int boardCodeId);	
	
	public boolean addArticle(Article article);
	public boolean modifyArticle(Article article);	
	public boolean removeArticle(int articleId);	

	public ArticleView getArticle(int articleId);
	public List<ArticleView> findArticles(Pagination pagination);
	public List<ArticleView> findNotices(Pagination pagination);	
	public int getTotalArticles(Pagination pagination);
	public boolean modifyShare(int isShare, int articleId);
	List<Page> getPageList(int parentBoardId);
	List<Page> getPageList(int parentBoardId, String userId);
	public List<Page> getSubList(int parentBoardCodeId);
	
	public boolean addQA(QA qa);
	public boolean modifyQA(QA qa);	
//	 remove QA가 없는 건 Article만 지워도 같이 지워진다.
	public QAView getQA(int articleId);
	public List<QAView> findQAs(Pagination pagination);
	
	// Etc
	public boolean increaseHit(int articleId);
	public boolean updownCommentCount(int articleId, boolean up);
}
