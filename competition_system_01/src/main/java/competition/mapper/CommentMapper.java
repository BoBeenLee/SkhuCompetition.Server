package competition.mapper;

import java.util.List;

import competition.domain.Comment;
import competition.domain.view.CommentView;

public interface CommentMapper {
	// Comment
	public int addComment(Comment comment);
	public int modifyComment(Comment comment);
	public int removeComment(int commentId);	
	public CommentView getComment(int commentId);
	public List<CommentView> findComments(int articleId);
}
