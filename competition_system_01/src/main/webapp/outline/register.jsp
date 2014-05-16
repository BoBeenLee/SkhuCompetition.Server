<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="login.less">
<link rel="stylesheet/less" type="text/css" href="common.less">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script src="//code.jquery.com/jquery.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>

<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">
</head>

<body class="test">
	<div class="container">
		<div class="content row">
			<div class="register">
				<form:form commandName="user">
					<table>
						<tr>
							<td>구분 :</td>
							<td><form:select path="authId">
									<form:option value="학생" />
									<form:option value="교수" />
									<form:option value="일반인" />
								</form:select></td>
						</tr>
						<tr>
							<td>아이디 :</td>
							<td><form:input path="userId" /></td>
						</tr>
						<tr>
							<td>이름 :</td>
							<td><form:input path="userName" /></td>
						</tr>
						<tr>
							<td>이메일 :</td>
							<td><form:input path="userEmail" /></td>
						</tr>
						<tr>
							<td>전화번호 :</td>
							<td><form:input path="userTel" /></td>
						</tr>
						<tr>
							<td>패스워드 :</td>
							<td><form:password path="userPW" /></td>
						</tr>
						<tr>
							<td>패스워드 재확인 :</td>
							<td><input type="password" /></td>
						</tr>
						<tr>
							<td>질문 :</td>
							<td><form:input path="question" /></td>
						</tr>
						<tr>
							<td>대답 :</td>
							<td><form:input path="answer" /></td>
						</tr>
						<tr>
							<td>학과 :</td>
							<td><form:input path="department" /></td>
						</tr>
						<tr>
							<td>그룹 패스워드 :</td>
							<td><form:input path="groupPW" /></td>
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
		</div>
	</div>
</body>
</html>