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
</head>
<style>
	hr{
		margin-top : 70px;
		margin-bottom : 70px;
	}
</style>
<body>
	<div class="container">
		<input class="span3" type="text" placeholder=".spn3">
		<form>
			<div class="controls-row">
				<input class="span5" type="text" placeholder=".span5">
			</div>
			<div class="controls-row">
				<input class="span4" type="text" placeholder=".span4">
				<input class="span1" type="text" placeholder=".span1">
			</div>
		</form>
		<hr />
		<form>
			<div class="controls">
				<span class="input-xlarge uneditable-input">수정할 수 없는 데이터</span>
			</div>
			<div class="controls">
				<input type="text" class="input-xlarge">
				<span class="help-inline">짧은 도움말</span>
			</div>
			<div class="controls controls-row">
				<input type="text" class="input-xlarge">
				<span class="help-block">한줄을 다 차지하는 긴 도움말 입니다.</span>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">저장하기</button>
				<button type="button" class="btn">취소</button>
			</div>
		</form>
		<form>
			<div class="controls-row">
				<input class="span5" type="text" placeholder=".span5">
			</div>
			<div class="controls-row">
				<input class="span4" type="text" placeholder=".span4">
				<input class="span1" type="text" placeholder=".span1">
			</div>
		</form>
	</div>
</body>
</html>