<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="register">
	<form:form action="sendRegister.do" method="post">
		<table>
			<tr>
				<td>구분 :</td>
				<td><select name="authId">
						<option value="ROLE_STUDENT">학생</option>
						<option value="ROLE_PROFESOR">교수</option>
						<option value="ROLE_USER">일반인</option>
				</select></td>
			</tr>
			<tr>
				<td>아이디 :</td>
		
				<td><input name="userId" /></td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input name="userName" /></td>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td><input name="userEmail" /></td>
			</tr>
			<tr>
				<td>전화번호 :</td>
				<td><input name="userTel" /></td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input name="userPw" type="password" /></td>
			</tr>
			<tr>
				<td>패스워드 재확인 :</td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td>질문 :</td>
				<td><input name="question" /></td>
			</tr>
			<tr>
				<td>대답 :</td>
				<td><input name="answer" /></td>
			</tr>
			<tr>
				<td>학과 :</td>
				<td><input name="department" /></td>
			</tr>
			<tr>
				<td>그룹 패스워드 :</td>
				<td><input name="groupPW" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form:form>

	<!-- 
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputEmail1" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="email" class="form-control" id="inputEmail1"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword1" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" id="inputPassword1"
								placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<button type="submit" class="btn btn-default">Login</button>
							<button type="submit" class="btn btn-default">Register</button>
							<button type="submit" class="btn btn-default">Forget</button>
						</div>
					</div>
				</form>
 -->
</div>