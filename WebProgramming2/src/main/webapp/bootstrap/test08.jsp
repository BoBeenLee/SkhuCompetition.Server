<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<style>
hr {
	margin-top: 70px;
	margin-bottom: 70px;
}

.dropdown-menu:nth-of-type(2) {
	top: 700%;
}
</style>
<body>
	<div class="container">
		<form>
			<div class="input-append">
				<input class="span2" type="text">
				<button class="btn" type="button">검색</button>
			</div>
			<br />
			<div class="input-append">
				<input class="span2" type="text">
				<div class="btn-group">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						작업 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴 1</a></li>
						<li><a href="#">메뉴 2</a></li>
					</ul>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴 1</a></li>
						<li><a href="#">메뉴 2</a></li>
					</ul>
				</div>
			</div>
			<br />
			<div class="input-prepend">
				<div class="btn-group">
					<button class="btn" data-toggle="dropdown">
						작업<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="#">메뉴 1</a></li>
						<li><a href="#">메뉴 2</a></li>
					</ul>
				</div>
				<input type="text">
			</div>
			<div class="btn-group">
				<button class="btn dropdown-toggle" data-toggle="dropdown">
					따로 작업 <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#">메뉴 1</a></li>
					<li><a href="#">메뉴 2</a></li>
					<li class="divider"></li>
					<li><a href="#">메뉴 2</a></li>
				</ul>
			</div>
		</form>
		<form>
			<div class="controls-row">
				<input class="span2" type="text" placeholder=".span2"> <input
					class="span3" type="text" placeholder=".span3"> <input
					class="span4" type="text" placeholder=".span4">
			</div>
			<div class="row">
				<select class="span1">
					<option>하나</option>
					<option>둘</option>
				</select> <select class="span2">
					<option>하나</option>
					<option>둘</option>
				</select> <select class="span3">
					<option>하나</option>
					<option>둘</option>
				</select>
			</div>
		</form>
	</div>
</body>
</html>