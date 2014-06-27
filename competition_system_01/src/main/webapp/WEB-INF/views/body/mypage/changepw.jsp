<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet/less" type="text/css" href="css/mypage/mypage.less" />	
	
<div class="changepw">
	<form class="form-horizontal" action="mypage/changepw.do" method="post">
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">이전
				패스워드 :</label>
			<div class="col-md-5">
				<input id="inputRePassword" name="preUserPW"
					class="form-control" type="password" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">패스워드
				:</label>
			<div class="col-md-5">
				<input id="inputRePassword" name="userPW" class="form-control"
					type="password" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputRePassword" class="col-md-3 control-label">패스워드
				재확인 :</label>
			<div class="col-md-5">
				<input id="inputRePassword" class="form-control" type="password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<input type="submit" class="btn btn-default" value="확인" />
			</div>
		</div>
	</form>
</div>