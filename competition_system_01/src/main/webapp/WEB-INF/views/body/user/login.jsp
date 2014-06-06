<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="login">
	<form class="form-horizontal" action="login_process.do" method="post" role="form">
		<div class="form-group">
			<label for="inputId" class="col-md-3 control-label">UserId</label>
			<div class="col-md-9">
				<input type="text" name="j_username" class="form-control"
					id="inputId" placeholder="UserId">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">Password</label>
			<div class="col-md-9">
				<input type="password" name="j_password" class="form-control"
					id="inputPassword" placeholder="Password">
			</div>
		</div>
		<div class="form-group form-inline">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="form-control btn btn-default">Login</button>
				<a href="user/register.do" class="btn btn-default" >Register</a> <a
					href="user/forget.do" class="btn btn-default" >Forget</a>
			</div>
		</div>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-error">${ errorMessage }</div>
		</c:if>
	</form>
</div>