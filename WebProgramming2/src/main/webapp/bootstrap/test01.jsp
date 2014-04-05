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
	.test{
		display : inline-block;
		width:50px;
		height:50px;
		background-color:#eee;
	}
	.test1{
		display : inline-block;
		width:50px;
		height:50px;
		background-color:#eee;
	}
	.test:nth-child(even){
		background-color : black;
	}
	.test:FIRST-CHILD {
		background-color : black;
	}
}
</style>
</head>
<body>
	<div class="test"></div>
	<div class="test"></div>
	<div class="test"></div>
	<div class="test1"></div>
	<div class="container">
		<div class="navbar">
			<div class="navbar-inner">
				<button type="button" class="btn btn-navbar" data-target=".nav-collapse"  data-toggle="collapse"></button>
				<a class="brand" href="http://www,skhu.ac.kr">웹 사이트 제목</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li><a href="http://www.google.com">구글</a></li>
						<li><a href="http://www.google.com">구글</a></li>
						<li><a href="http://www.google.com">구글</a></li>
					</ul>
				</div>
			</div>
		</div>
		<h1>Bootstrap 예제 페이지 01</h1>
		<p>
			Use this document as a way
		</p>
	</div>
</body>
</html>