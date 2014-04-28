<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.io.*, java.sql.*, java.util.*, bbs.*"%>
<%
	request.setCharacterEncoding("utf-8");
	if ("저장".equals(request.getParameter("cmd"))) {
		Guestbook g = new Guestbook();
		g.setText(request.getParameter("text"));
		g.setName(request.getParameter("name"));
		g.setPasswd(request.getParameter("password"));
		g.setDate(new Timestamp(new java.util.Date().getTime()));
		g.setIP(request.getRemoteAddr());
		GuestbookHome1.insert(g);
	}
%>
<STYLE TYPE="text/css">
table {
	border-collapse: collapse;
	width: 500px;
}

td {
	padding: 5px;
	font-Size: 9pt;
}

td.header {
	background-color: #EEEEEE;
	color: #666666;
	border-top: 1pt solid #BBBB88;
}

td.body {
	height: 50px;
	vertical-align: top
}
</STYLE>
<form method="post">
	이름: <input type="text" name="name" size=20 tabindex=1>
	&nbsp;&nbsp; 암호: <input type="password" name="password" size=10
		tabindex=2> &nbsp;&nbsp; <input name="cmd" type="submit"
		value="저장" tabindex=4> <br>
	<textarea name="text" rows=4 cols=60 tabindex=3></textarea>
	<br>
</form>
<table>
	<%
		for (Guestbook g : GuestbookHome1.selectAll()) {
	%>
	<TR>
		<TD class=header>no.<%=g.getId()%> &nbsp; &nbsp; <%=g.getName()%>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; (<%=g.getDateLong()%>, IP:<%=g.getIP()%>)
		</TD>
	</TR>
	<TR>
		<TD class=body><%=g.getText()%></TD>
	</TR>
	<%
		}
	%>
</table>
