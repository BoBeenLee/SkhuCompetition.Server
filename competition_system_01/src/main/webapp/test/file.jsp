<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/competition_system_01/filetest.do" > filetest </a>
	<form action="/competition_system_01/filetest.do" method="post"
		enctype="multipart/form-data">
		파일#1: <input type="file" name="file1" /> <br /> 파일#2: <input
			type="file" name="file2" /> <br /> <input type="submit" value="업로드" />
	</form>
</body>
</html>