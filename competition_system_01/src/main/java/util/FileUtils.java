package util;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import competition.domain.view.FileView;
import competition.service.FileService;

public class FileUtils {
	public static final String FILE_PATH = "G:/dev/eclipse-ee/git/CompetitionSystem/competition_system_01/src/main/webapp/file/";
	public static final String FILE_RELATIVE_PATH = "webapps/competition_system_01/file/";
	@Autowired
	FileService fileService;
	
	public static FileView getUploadFile(MultipartFile uploadfile, int articleId, String userId, int isArticle){
		FileView fileView = null;
		
		 if (uploadfile != null && uploadfile.getSize() > 0) {
			 	fileView = new FileView();
	            String fileName = uploadfile.getOriginalFilename();
	            String fileUrl = FILE_PATH + articleId + "-" + userId + "-" + fileName;
	            String fileRelativeUrl = FILE_RELATIVE_PATH + articleId + "-" + userId + "-" + fileName;
	            
	            //System.out.println((new File(fileRelativeUrl)).getAbsolutePath());
	            
	            if(fileName.endsWith(".jsp") || fileName.endsWith(".php"))
	            	return null;
	            
	            File file = new File(fileRelativeUrl);
	            
	            fileView.setFileName(fileName);
	            fileView.setArticleId(articleId);
	            fileView.setUserId(userId);
	            fileView.setFileSize(uploadfile.getSize());
	            fileView.setFileType(uploadfile.getContentType());
	            fileView.setFileUrl(file.getAbsolutePath());
	            fileView.setIsArticle(isArticle);
	            
	            try {
	                //File file = new File(fileRelative.getAbsolutePath());
	                uploadfile.transferTo(file);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	    }
		return fileView;
	}
}
