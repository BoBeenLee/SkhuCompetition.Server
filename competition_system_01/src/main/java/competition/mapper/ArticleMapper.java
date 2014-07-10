package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import competition.domain.Article;
import competition.domain.Pagination;
import competition.domain.QA;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.QAView;
import competition.domain.view.code.BoardCodeView;


public interface ArticleMapper{
//	 QAs 만 빼고 테스트 해봄.
	
	public int addBoardCode(BoardCode boardCode);
	public int removeBoard(int boardCodeId);
	public int modifyBoardCode(BoardCode boardCode);
	public List<BoardCodeView> getAllBoardCodes();	
	public BoardCodeView getBoard(@Param("boardCodeId") int boardCodeId, @Param("isHidden") int isHidden);
	public List<BoardCodeView> findBoards(@Param("isHidden") int isHidden, @Param("builderId") String builderId, @Param("parentBoardCodeId") int parentBoardCodeId);
	
	public int addQA(QA qa);
	public int modifyQA(QA qa);	
	
	public QAView getQA(int articleId);
	public List<QAView> findQAs(Pagination pagination);
	
	
	public int addArticle(Article article);
	public int modifyArticle(Article article);	
	public int removeArticle(int articleId);	
	
	public ArticleView getArticle(int articleId);
	public List<ArticleView> findArticles(Pagination pagination);
	public List<ArticleView> findNotices(Pagination pagination);	
	public int getTotalArticles(Pagination pagination);
	public int modifyShare(@Param("isShare") int isShare, @Param("articleId") int articleId);
	
	public String getBoardName(int boardCodeId);
	public int increaseHit(int articleId);
	public int updownCommentCount(@Param("articleId") int articleId, @Param("count") int count);	
}
