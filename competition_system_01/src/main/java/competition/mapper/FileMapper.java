package competition.mapper;

import java.util.List;

import competition.domain.Article;
import competition.domain.Calendar;
import competition.domain.File;
import competition.domain.Pagination;
import competition.domain.code.BoardCode;
import competition.domain.view.ArticleView;
import competition.domain.view.CalendarView;
import competition.domain.view.FileView;
import competition.domain.view.QAView;

public interface FileMapper {
	// File
	public void addFile(File file);
	public void removeFile(int id);	
	public FileView getFile(int id);
	public List<FileView> findCalendar();
}
