package competition.domain.view;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import competition.domain.File;

public class FileView extends File{
	private MultipartFile uploadfile;
	private List<TagView> tagList;
	private String teamName;
	
	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	public List<TagView> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagView> tagList) {
		this.tagList = tagList;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
}
