<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
	/* border : 1px solid black; */
	
}

.header {
	height: 50px;
}

.menu  {
	height: 100px;
}

.content {
	height: 250px;
}

.box {
	height: 30px;
}

.footer {
	height: 50px;
}

.container div {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row header"></div>
		<div class="row menu"></div>
		<div class="row content">
			<div class="box col-md-7">test</div>
			<div class="box col-md-3">test</div>
		</div>
		<div class="row footer"></div>
	</div>
</body>
</html>