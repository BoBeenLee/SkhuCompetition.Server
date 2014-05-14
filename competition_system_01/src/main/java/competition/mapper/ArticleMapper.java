package competition.mapper;

import java.util.List;

import competition.domain.Article;
import competition.domain.Pagination;
import competition.domain.QA;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.QAView;

public interface ArticleMapper{
	public void addArticle(Article article);
	public void removeArticle(int id);	
	public ArticleView getArticle(int id);
	public QAView getQA(int id);
	
	public List<ArticleView> findArticle(BoardCode boardCode, Pagination pagination);
	public List<QAView> findQA(BoardCode boardCode, Pagination pagination);
	
	
}
