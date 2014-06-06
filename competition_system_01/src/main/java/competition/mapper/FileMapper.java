package competition.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import competition.domain.File;
import competition.domain.view.FileView;

public interface FileMapper {
	// File
	public int addFile(File file);
	public int removeFile(int fileId);	
	public FileView getFile(int fileId);
	public List<FileView> findFiles(@Param("articleId") int articleId, @Param("userId") String userId, @Param("isArticle") int isArticle);
}
