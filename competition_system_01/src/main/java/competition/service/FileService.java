package competition.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.File;
import competition.domain.view.FileView;

public interface FileService {
	// File
	public boolean addFile(File file);
	public boolean removeFile(int fileId);	
	public FileView getFile(int fileId);
	public List<FileView> findFiles(int articleId, String userId, int isArticle);
}
