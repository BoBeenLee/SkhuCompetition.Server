<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet/less" type="text/css" href="css/user/user.less">
	
<div class="register">
	<form class="form-horizontal" action="user/register.do" method="post">
		<div class="form-group">
			<label for="inputType" class="col-md-3 control-label">구분 : </label>
			<div class="col-md-5">
				<select id="inputType" class="form-control" name="authName">
					<option value="ROLE_STUDENT">학생</option>
					<option value="ROLE_PROFESOR">교수</option>
					<option value="ROLE_USER">일반인</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputId" class="col-md-3 control-label">아이디 : </label>
			<div class="col-md-5">
				<input id="inputId" type="text" placeholder="3글자 이상" class="form-control" name="userId" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputName" class="col-md-3 control-label">이름 : </label>
			<div class="col-md-5">
				<input id="inputName" type="text" placeholder="Name" class="form-control" name="userName" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="col-md-3 control-label">이메일 :
			</label>
			<div class="col-md-5">
				<input id="inputEmail" placeholder="example@example.com"  type="text" class="form-control"
					name="userEmail" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputTel" class="col-md-3 control-label">전화번호 :</label>
			<div class="col-md-5">
				<input id="inputTel" type="text" placeholder="phoneNumber" class="form-control" name="userTel" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">패스워드
				:</label>
			<div class="col-md-5">
				<input type="password" id="inputPassword" placeholder="password" class="form-control"
					name="userPW" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputRePassword" class="col-md-3 control-label">패스워드
				재확인 :</label>
			<div class="col-md-5">
				<input id="inputRePassword" placeholder="password" class="form-control" type="password" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputQuestion" class="col-md-3 control-label">질문
				:</label>
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
			<label for="inputAnswer" class="col-md-3 control-label">대답 :</label>
			<div class="col-md-5">
				<input id="inputAnswer" type="text" placeholder="answer" class="form-control" name="answer" />
			</div>
		</div>		
		<div class="form-group">
			<label for="inputGrade" class="col-md-3 control-label">학년
				:</label>
			<div class="col-md-5">
				<input id="inputGrade" type="text" placeholder="grade" class="form-control"
					name="grade" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputDepartment" class="col-md-3 control-label">학과
				:</label>
			<div class="col-md-5">
				<input id="inputDepartment" type="text" placeholder="department" class="form-control"
					name="department" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputGroupPW" class="col-md-3 control-label">그룹
				패스워드 :</label>
			<div class="col-md-5">
				<input id="inputGroupPW" type="password" placeholder="group password" class="form-control"
					name="groupPW" />
			</div>
		</div>
		<div class="form-group">
				<label class="col-md-3 control-label"></label>
				<div class="col-md-5">
					<input type="submit" class="btn" value="확인" /> <a
					href="index.do" class="btn">취소</a>
				</div>
		</div>
	</form>
</div>