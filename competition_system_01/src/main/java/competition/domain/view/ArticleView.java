package competition.domain.view;

import java.sql.Blob;
import java.sql.Timestamp;
import java.text.ParseException;

import org.springframework.web.multipart.MultipartFile;

import util.DateUtils;
import competition.domain.Article;

public class ArticleView extends Article{
	private MultipartFile uploadfile;
	
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public void setContentView(String content){
		setContent(content.getBytes());
	}
	public String getContentView(){
		if(getContent() != null)
			return new String(getContent());
		else 
			return "";
	}
	public void setStartPeriodView(String startPeriod) throws ParseException {
		if(startPeriod == null || startPeriod.equals(""))
			return ;
		setStartPeriod(DateUtils.getStringToDate(startPeriod));
	}
	public String getStartPeriodView() {
		return DateUtils.getDateToString(super.getStartPeriod());
	}
	public void setEndPeriodView(String endPeriod) throws ParseException {
		if(endPeriod == null || endPeriod.equals(""))
			return ;
		setEndPeriod(DateUtils.getStringToDate(endPeriod));
	}
	public String getEndPeriodView() {
		return DateUtils.getDateToString(super.getEndPeriod());
	}
	public void setFileLimitDateView(String fileLimitDate) throws ParseException {
		fileLimitDate = fileLimitDate.trim();
		
		if(fileLimitDate == null || fileLimitDate.equals(""))
			return ;
		setFileLimitDate(DateUtils.getStringToDateTime(fileLimitDate));
	}
	public String getFileLimitDateView() {
		return DateUtils.getDateTimeToString(super.getFileLimitDate());
	}
	public boolean getIsFileView() {
		return getIsFile() == 1;
	}

	public void setIsFileView(boolean isFile) {
		setIsFile((isFile)? 1 : 0);
	}
	
	public boolean getIsNoticeView() {
		return getIsNotice() == 1;
	}

	public void setIsNoticeView(boolean isNotice) {
		setIsNotice((isNotice)? 1 : 0);
	}
}
