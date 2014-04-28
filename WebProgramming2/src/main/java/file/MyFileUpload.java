package file;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class MyFileUpload {
	static String PROPERTIES_FILE = "file/MyFileUpload.properties";
	static String UPLOAD_PATH;

	static {
		try {
			InputStream inputstream = MyFileUpload.class.getClassLoader()
					.getResourceAsStream(PROPERTIES_FILE);
			Properties properties = new Properties();
			properties.load(inputstream);
			UPLOAD_PATH = properties.getProperty("UPLOAD_PATH");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<FileItem> process(HttpServletRequest request)
			throws Exception {
		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!isMultipartContent) {
			throw new Exception("enctype is not 'multipart/form-data'");
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1 * 1024 * 1024);
		factory.setRepository(new File(UPLOAD_PATH));
		List<FileItem> fileItemList = new ServletFileUpload(factory)
				.parseRequest(request);
		List<FileItem> resultList = new ArrayList<FileItem>();

		for (FileItem fileItem : fileItemList) {
			if (!fileItem.isFormField()) {
				File diskFile = new File(UPLOAD_PATH, fileItem.getFieldName());
				fileItem.write(diskFile);
				resultList.add(fileItem);
				fileItem.delete();
			}
		}
		return resultList;
	}

}
