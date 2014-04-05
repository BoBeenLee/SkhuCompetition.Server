<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<style>
	div.span2 { background-color: #aaffaa; height: 400px; }
	div.span10 { background-color: #ffffaa; height: 200px; }
	.row{
		background-color: #eee;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row"'>
			<div class="span2">왼쪽 영역 내용</div>
			<div class="span10">본문 내용</div>
		</div>
	</div>
	<hr />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				왼쪽 영역 내용
			</div>
			<div class="span10">
				본문 내용
			</div>
		</div>
	</div>
</body>
</html>