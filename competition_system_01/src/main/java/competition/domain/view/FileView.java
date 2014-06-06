package competition.domain.view;

import org.springframework.web.multipart.MultipartFile;

import competition.domain.File;

public class FileView extends File{
	private MultipartFile uploadfile;

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
}
