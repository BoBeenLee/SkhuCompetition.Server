package competition.domain.view;

import competition.domain.Comment;

public class CommentView extends Comment {
	private String title;
	
	public void setContentView(String content) {
		setContent(content.getBytes());
	}

	public String getContentView() {
		if (getContent() != null)
			return new String(getContent());
		else
			return "";
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
