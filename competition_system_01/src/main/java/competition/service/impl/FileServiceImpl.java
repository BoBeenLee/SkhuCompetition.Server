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
		List<FileView> fileList = findFiles(articleId, userId, 0, isArticle);
		return fileList;
	}
	public List<FileView> findFiles(int articleId, int teamCodeId, int isArticle) {
		List<FileView> fileList = findFiles(articleId, null, teamCodeId, isArticle);
		return fileList;
	}
	public List<FileView> findFiles(int articleId, String userId, int teamCodeId, int isArticle) {
		List<FileView> fileList = fileMapper.findFiles(articleId, userId, teamCodeId, isArticle);
		return fileList;
	}
}
