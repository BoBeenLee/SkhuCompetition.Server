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
	hr{
		margin-top : 70px; margin-bottom : 70px;
	}
</style>
</head>
<body>
	<div class="container">
		<form class="form-horizontal">
			<div class="control-group">
			<label class="control-label"  for="inputEmail">이메일</label>
				<div class="controls">
					<input type="text" id="inputEmail" placeholder="이메일">
				</div>
				<label class="control-label"  for="inputEmail">이메일</label>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPassword">비밀번호</label>
				<div class="controls">
					<input type="password" id="inputPasword" placeholder="비밀번호">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"><input type="checkbox"></label>
					<button type="submit" class="btn">로그인</button>
				</div>
			</div>
		</form>
		<form>
			<div class="input-prepend">
				<span class="add-on">@</span>
				<input class="span2" type="text" placeholder="사용자명">
			</div> <br/>
			<div class="input-append">
				<input class="span2" type="text" placeholder="무게">
				<span class="add-on">kg</span>
			</div>
			<div class="input-prepend input-append">
				<input class="span2" type="text">
			</div> <br />
			<div class="input-append">
				<input class="span4" type="text">
				<button class="btn" type="button">검색</button>
			</div>
		</form>
	</div>
</body>
</html>
