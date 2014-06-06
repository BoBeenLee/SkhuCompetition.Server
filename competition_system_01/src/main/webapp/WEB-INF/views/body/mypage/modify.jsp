<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="modify">
	<form:form class="form-horizontal" commandName="userView"
		action="mypage/modify.do" method="post">
		<div class="form-group">
			<label for="inputName" class="col-md-3 control-label">이름 : </label>
			<div class="col-md-5">
				<form:input id="inputName" class="form-control" path="userName" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputEmail" class="col-md-3 control-label">이메일 :
			</label>
			<div class="col-md-5">
				<form:input id="inputEmail" class="form-control"
					path="userEmail" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputTel" class="col-md-3 control-label">전화번호 :</label>
			<div class="col-md-5">
				<form:input id="inputTel" class="form-control" path="userTel" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputQuestion" class="col-md-3 control-label">질문
				:</label>
			<div class="col-md-5">
				<form:input id="inputQuestion" class="form-control"
					path="question" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputAnswer" class="col-md-3 control-label">대답 :</label>
			<div class="col-md-5">
				<form:input id="inputAnswer" class="form-control" path="answer" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputGrade" class="col-md-3 control-label">학년
				:</label>
			<div class="col-md-5">
				<form:input id="inputGrade" class="form-control"
					path="grade" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputDepartment" class="col-md-3 control-label">학과
				:</label>
			<div class="col-md-5">
				<form:input id="inputDepartment" class="form-control"
					path="department" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputGroupPW" class="col-md-3 control-label">그룹
				패스워드 :</label>
			<div class="col-md-5">
				<form:password id="inputGroupPW" class="form-control"
					path="groupPW" />
			</div>
		</div>
		<div class="form-group">
			<input type="submit" class="btn col-md-offset-3" value="확인" /> <a
				href="mypage/mypage.do" class="btn">취소</a>
		</div>
	</form:form>
</div>