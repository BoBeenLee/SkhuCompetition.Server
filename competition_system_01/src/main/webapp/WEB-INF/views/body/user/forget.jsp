<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet/less" type="text/css" href="css/user/user.less">
	
<div class="forget">
	<form class="form-horizontal" action="user/forget.do" method="post">
		<div class="form-group">
			<label for="inputUserId1" class="col-md-3 control-label">UserId</label>
			<div class="col-md-5">
				<input type="text" name="userId" id="inputUserId1" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail1" class="col-md-3 control-label">Email</label>
			<div class="col-md-5">
				<input type="email" name="userEmail" class="form-control"
					id="inputEmail1" placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-offset-3 col-md-9">
				<button type="submit" class="btn btn-default">비밀번호찾기</button>
			</div>
		</div>
	</form>
	<form class="form-horizontal" action="user/forget.do" method="post">
		<div class="form-group">
			<label for="inputUserId2" class="col-md-3 control-label">UserId</label>
			<div class="col-md-5">
				<input type="text" name="userId" id="inputUserId2" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputQuestion1" class="col-md-3 control-label">Question</label>
			<div class="col-md-5">
				<select id="inputQuestion" class="form-control"
					name="question">
					<option value="1">나의 보물 제 1호는?</option>
          			<option value="2">어머니 고향은?</option>
		          	<option value="3">아버지 고향은?</option>
				</select>
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
</div>