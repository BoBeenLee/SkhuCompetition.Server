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
	
</style>
<body>
	<div class="container">
		<form>
			<fieldset>
				<legend>양</legend>
				<label>항목명</label>
				<input type="text" class="input-small" placeholder="아무거나 입력하시요...">
				<span class="help-block">한줄을 다 차지하는 도움말 문자열 임니다.</span>
				<label class="checkbox">
					<input type="checkbox" /> 체크하시오
				</label>
				<button type="submit" class="btn btn-primary">
					<i class="icon-hdd icon-white"></i>확인
				</button>
				<a class="btn">취소</a>
			</fieldset>
		</form>
		<form>
			<input type="text" class="input-medium search-query">
			<button type="submit" class="btn">검색</button>
		</form>
		<hr />
		
		<form>
			<input type="text" class="input-small" placeholder="이메일">
			<input type="password" class="input-small" placeholder="비밀번호">
			<label class="checkbox">
				<input type="checkbox"> 자동 로그인
			</label>
			<button type="submit" class="btn">로그인</button>
		</form>
	</div>
</body>
</html>