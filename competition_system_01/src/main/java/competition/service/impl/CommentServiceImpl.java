package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.Comment;
import competition.domain.view.CommentView;
import competition.mapper.CommentMapper;
import competition.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired(required=false)
	CommentMapper commentMapper;
	
	public boolean addComment(Comment comment) {
		boolean isComment = (1 == commentMapper.addComment(comment))? true : false;
		return isComment;
	}

	public boolean modifyComment(Comment comment) {
		boolean isComment = (1 == commentMapper.modifyComment(comment))? true : false;
		return isComment;
	}

	public boolean removeComment(int commentId) {
		boolean isComment = (1 == commentMapper.removeComment(commentId))? true : false;
		return isComment;
	}

	public CommentView getComment(int commentId) {
		CommentView comment = commentMapper.getComment(commentId);
		return comment;
	}

	public List<CommentView> findComments(int articleId) {
		List<CommentView> commentList = commentMapper.findComments(articleId);
		return commentList;
	}

	public List<CommentView> findBoardComments(int boardCodeId) {
		List<CommentView> commentList = this.findBoardComments(boardCodeId, 0);
		return commentList;
	}

	public List<CommentView> findBoardComments(int boardCodeId, int isShare) {
		List<CommentView> commentList = commentMapper.findBoardComments(boardCodeId, isShare);
		return commentList;
	}
}
