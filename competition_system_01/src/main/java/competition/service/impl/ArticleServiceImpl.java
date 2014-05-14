package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.view.ArticleView;
import competition.mapper.ArticleMapper;
import competition.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	
	public boolean addArticle() {
		System.out.println(articleMapper);
		
		
		return false;
	}

	public boolean modifyArticle() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeArticle() {
		// TODO Auto-generated method stub
		return false;
	}

	public ArticleView getArticle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ArticleView> findArticle(){
		return null;
	}
}
