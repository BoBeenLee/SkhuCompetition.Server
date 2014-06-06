package competition.domain.view;

import competition.domain.Score;

public class ScoreView extends Score{
//	File DB
	private String fileName;
	private int fileId;
	private String title;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
}
