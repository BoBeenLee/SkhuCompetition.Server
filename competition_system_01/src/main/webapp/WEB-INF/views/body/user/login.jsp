<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet/less" type="text/css" href="css/user/user.less">

<div class="login">
	<form class="form-horizontal" action="login_process.do" method="post" role="form">
		<div class="form-group">
			<label for="inputId" class="col-md-3 control-label">아이디</label>
			<div class="col-md-9">
				<input type="text" name="j_username" class="form-control"
					id="inputId" placeholder="아이디">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">비밀번호</label>
			<div class="col-md-9">
				<input type="password" name="j_password" class="form-control"
					id="inputPassword" placeholder="비밀번호">
			</div>
		</div>
		<div class="form-group form-inline">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="form-control btn btn-default">로그인</button>
				<a href="user/register.do" class="btn btn-default" >회원가입</a> <a
					href="user/forget.do" class="btn btn-default" >아이디/비밀번호 찾기</a>
			</div>
		</div>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-error">${ errorMessage }</div>
		</c:if>
	</form>
</div>