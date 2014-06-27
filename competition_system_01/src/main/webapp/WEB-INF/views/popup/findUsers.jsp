<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet/less" type="text/css"
	href="css/popup/findusers.less">
	
<div class="findUsers">
	<hr>
	<form action="popup/findUsers.do" method="get">
		<div class="input-group">
			<span class="input-group-btn">
				<select name="st" class="input-sm">
					<option value="userId">아이디</option>
					<option value="userName">이름</option>
					<option value="department">학과</option>
				</select>
			</span>
			<input type="text" name="ct" class="form-control" /> <span
				class="input-group-btn"> <input
				class="btn btn-default" type="submit" value="검색" />
			</span>
		</div>
	</form>
	<hr>
	<table ng-controller="ReturnCtrl"
		class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>학과</td>
				<td>이메일</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${ userList }">
				<tr ng-click="setParent('${ user.userId }', '${ user.userName }')">
					<td>${ user.userId }</td>
					<td>${ user.userName }</td>
					<td>${ user.department }</td>
					<td>${ user.userEmail }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>