<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="chkpw">
	<form class="form-horizontal" action="mypage/modify.do" method="post"
		role="form">
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">Password</label>
			<div class="col-md-6">
				<input type="password" name="userPW" class="form-control"
					id="inputPassword" placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="btn btn-default">확인</button>
			</div>
		</div>
		<input type="hidden" name="cmd" value="modify" />
	</form>
</div>