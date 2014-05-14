package competition.service;

import competition.domain.view.ArticleView;

public interface ArticleService {
	public boolean addArticle();

	public boolean modifyArticle();

	public boolean removeArticle();

	public ArticleView getArticle();
}
