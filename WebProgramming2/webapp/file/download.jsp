<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.io.*"%>
<%
	String 다운로드할파일 = "d:/file1.jpg";

	response.setContentType("application/octet-stream");
	response.setHeader("Content-Disposition",
			"attachment;filename=photo.jpg;");

	BufferedInputStream input = new BufferedInputStream(
			new FileInputStream(다운로드할파일));
	BufferedOutputStream output = new BufferedOutputStream(
			response.getOutputStream());
	int count = 0;
	byte buffer[] = new byte[10240];
	try {
		while ((count = input.read(buffer)) != -1)
			output.write(buffer, 0, count);
	} catch (Exception e) {
		out.println(e.getMessage());
	} finally {
		output.close();
		input.close();
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>