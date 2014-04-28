<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*, javax.servlet.http.*, org.apache.commons.fileupload.*, file.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*, org.apache.commons.fileupload.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
List<FileItem> fileItemList =  MyFileUpload.process(request);
for (FileItem fileItem : fileItemList) { 
%>
        <table border="1">     
            <tr>
                <td>form field name:</td>
                <td><%= fileItem.getFieldName() %></td>
            </tr>
            <tr>
                <td>file name:</td>
                <td><%= fileItem.getName() %></td>
            </tr>
            <tr>
                <td>content type:</td>
                <td><%= fileItem.getContentType() %></td>
            </tr>
            <tr>
                <td>file size:</td>
                <td><%= fileItem.getSize() %></td>
            </tr>
        </table>
        <br />
<%
}
%>        
</body>
</html>