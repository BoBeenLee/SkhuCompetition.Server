<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, org.apache.commons.fileupload.*" %>
<%@ page isELIgnored="false"%>
<%
	List<FileItem> fileItemList = null; //(List) request.getAttribute("resultList");
	for (FileItem fileItem : fileItemList) {
%>

<table border="1">
	<tr>
		<td>form field name:</td>
		<td><%=fileItem.getFieldName()%></td>
	</tr>
	<tr>
		<td>file name:</td>
		<td><%=fileItem.getName()%></td>
	</tr>
	<tr>
		<td>content type:</td>
		<td><%=fileItem.getContentType()%></td>
	</tr>
	<tr>
		<td>file size:</td>
		<td><%=fileItem.getSize()%></td>
	</tr>
</table>
<br />

 <%
	}
%>