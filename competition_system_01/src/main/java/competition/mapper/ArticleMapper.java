package competition.mapper;

import java.util.List;

import competition.domain.Article;
import competition.domain.Comment;
import competition.domain.Pagination;
import competition.domain.QA;
import competition.domain.User;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.QAView;
import competition.domain.view.UserView;

public interface ArticleMapper{
	
	// Article
	public void addArticle(Article article);
	public void removeArticle(int id);	
	public void modifyArticle(Article article);
	public ArticleView getArticle(int id);
	public QAView getQA(int id);
	
	public List<ArticleView> findArticle();
	//public List<ArticleView> findArticle(BoardCode boardCode, Pagination pagination);
	public List<QAView> findQA(BoardCode boardCode, Pagination pagination);
	
	// Comment
	public void addComment(Comment comment);
	public void removeComment(int id);
	public void modifyComment(Comment comment);
	public List<UserView> findComment(Pagination pagination);
}
