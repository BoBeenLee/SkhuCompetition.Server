<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<input id="inputId" type="text" class="form-control" name="userId" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputName" class="col-md-3 control-label">이름 : </label>
			<div class="col-md-5">
				<input id="inputName" type="text" class="form-control" name="userName" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="col-md-3 control-label">이메일 :
			</label>
			<div class="col-md-5">
				<input id="inputEmail" type="text" class="form-control"
					name="userEmail" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputTel" class="col-md-3 control-label">전화번호 :</label>
			<div class="col-md-5">
				<input id="inputTel" type="text" class="form-control" name="userTel" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword" class="col-md-3 control-label">패스워드
				:</label>
			<div class="col-md-5">
				<input type="password" id="inputPassword" class="form-control"
					name="userPW" />
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
			<label for="inputQuestion" class="col-md-3 control-label">질문
				:</label>
			<div class="col-md-5">
				<input id="inputQuestion" type="text" class="form-control"
					name="question" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputAnswer" class="col-md-3 control-label">대답 :</label>
			<div class="col-md-5">
				<input id="inputAnswer" type="text" class="form-control" name="answer" />
			</div>
		</div>		
		<div class="form-group">
			<label for="inputGrade" class="col-md-3 control-label">학년
				:</label>
			<div class="col-md-5">
				<input id="inputGrade" type="text" class="form-control"
					name="grade" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputDepartment" class="col-md-3 control-label">학과
				:</label>
			<div class="col-md-5">
				<input id="inputDepartment" type="text" class="form-control"
					name="department" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputGroupPW" class="col-md-3 control-label">그룹
				패스워드 :</label>
			<div class="col-md-5">
				<input id="inputGroupPW" type="password" class="form-control"
					name="groupPW" />
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn col-md-offset-3" value="확인" /> <a
				href="index.do" class="btn">취소</a>
		</div>
	</form>
</div>