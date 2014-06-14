package competition.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import competition.domain.File;
import competition.domain.view.FileView;
import competition.mapper.FileMapper;
import competition.service.FileService;

@Service("fileService")
public class FileServiceImpl implements FileService {
	@Autowired(required=false)
	FileMapper fileMapper;
	
	public boolean addFile(File file) {
		boolean isFile = (1 == fileMapper.addFile(file))? true : false;
		return isFile;
	}

	public boolean removeFile(int fileId) {
		boolean isFile = (1 == fileMapper.removeFile(fileId))? true : false;
		return isFile;
	}

	public FileView getFile(int fileId) {
		FileView file = fileMapper.getFile(fileId);
		return file;
	}

	
	
	public List<FileView> findFiles(int articleId, String userId, int isArticle) {
		List<FileView> fileList = fileMapper.findFiles(articleId, userId, isArticle);
		return fileList;
	}
}
