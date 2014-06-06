<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="forget">
	<form class="form-horizontal" action="login_process.do" method="post">
		<div class="form-group">
			<label for="inputEmail1" class="col-md-3 control-label">Email</label>
			<div class="col-md-5">
				<input type="email" name="email" class="form-control"
					id="inputEmail1" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="btn btn-default">비밀번호찾기</button>
			</div>
		</div>
	</form>
	<form class="form-horizontal" action="login_process.do" method="post">
		<div class="form-group">
			<label for="inputQuestion1" class="col-md-3 control-label">Question</label>
			<div class="col-md-5">
				<label id="inputQuestion1" class="form-control">Question1</label>
			</div>
		</div>
		<div class="form-group">
			<label for="inputAnswer1" class="col-md-3 control-label">Answer</label>
			<div class="col-md-5">
				<input type="text" name="answer" class="form-control"
					id="inputAnswer1" placeholder="Answer">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="btn btn-default">비밀번호찾기</button>
			</div>
		</div>
	</form>

	<c:if test="${not empty errorMessage}">
		<div class="alert alert-error">${ errorMessage }</div>
	</c:if>

</div>