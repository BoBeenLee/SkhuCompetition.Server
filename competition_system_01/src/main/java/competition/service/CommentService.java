package competition.service;

import java.util.List;

import competition.domain.Comment;
import competition.domain.view.CommentView;

public interface CommentService {
	// Comment
	public boolean addComment(Comment comment);
	public boolean modifyComment(Comment comment);
	public boolean removeComment(int commentId);	
	public CommentView getComment(int commentId);
	public List<CommentView> findComments(int articleId);
	public List<CommentView> findBoardComments(int boardCodeId);
	public List<CommentView> findBoardComments(int boardCodeId, int isShare);
}
