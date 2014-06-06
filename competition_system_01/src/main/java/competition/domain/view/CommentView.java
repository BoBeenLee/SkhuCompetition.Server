package competition.domain.view;

import competition.domain.Comment;

public class CommentView extends Comment {
	public void setContentView(String content){
		setContent(content.getBytes());
	}
	public String getContentView(){
		if(getContent() != null)
			return new String(getContent());
		else 
			return "";
	}
}
