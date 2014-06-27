package competition.domain.view;

public class ContentView {
	byte[] content;
	
	
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public void setContentView(String content) {
		setContent(content.getBytes());
	}

	public String getContentView() {
		if (getContent() != null)
			return new String(getContent());
		else
			return "";
	}
}
