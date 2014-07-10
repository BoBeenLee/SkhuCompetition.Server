<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet/less" type="text/css" href="css/mypage/mypage.less" />

<div class="grantadmin">
	<div ng-controller="OpenWindowCtrl" class="user" 
	ng-init="init([
		<c:set var="comma" value="0" />
		<c:forEach var="user" varStatus="idx" items="${ userList }">
			<c:if test="${ user.userId != 'admin' }">
				<c:if test="${ comma != 0 }">, </c:if>	
				<c:if test="${ comma == 0 }"><c:set var="comma" value="1" /></c:if>	
				{
					itemId : '${ user.userId }',
					itemName : '${ user.userName }'
				}				
			</c:if>
		</c:forEach>  
	])"	>
	<h5>관리자 권한 명단</h5>
	<form action="mypage/grantadmin.do" method="post">
		<div class="userList">
			<!-- 사용자 명단을 어떻게 불러올 것인가?? -->
			<ul>
				<li ng-repeat="item in itemList"><input type="hidden"
					name="userList" value="{{ item.itemId }}" /> 아이디 : {{
					item.itemId }} - 이름 : {{ item.itemName }}
					<a href="mypage/returnauth.do?ui={{ item.itemId }}">권한취소</a>
				</li>
			</ul>
		</div>
		<div class="form-group">
			<input type="button" ng-click="popup('findUsers.do')"
				class="btn btn-default" value="찾기" />
			<input type="submit" class="btn btn-default" value="저장" />
		</div>
	</form>
	</div>	
</div>