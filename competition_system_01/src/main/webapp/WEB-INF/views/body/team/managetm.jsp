<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sec:authentication property="name" var="currentUserName"/>

<div class="managetm">
	<div ng-controller="BidToTidCtrl" class="manage-header" ng-init="init('${ teamList.boardCodeId }', '${ teamList.teamCodeId }', 'team/tclist.do')">
		<form class="form-inline" action="team/managetm.do" method="get">
			<select name="bid" class="form-control input-sm" ng-model="bid" ng-change="getSelectedBid('team/tclist.do')">
				<c:forEach var="boardCode" items="${ boardCodeList }">
					<option value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
				</c:forEach>
			</select> 
			<select name="tid" class="form-control input-sm" ng-model="tid">
				<option ng-selected="{{tid == team.teamCodeId}}" ng-repeat="team in teamList" value="{{ team.teamCodeId }}">{{team.teamName}}</option>
			</select>
			<input class="form-control btn btn-default" type="submit"
				value="조회" />
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
			<a href="mail/send.do?bid={{ bid }}" class="btn btn-default pull-right">신청자 메일 보내기</a>
		</sec:authorize>
		</form>
		<hr>
		<div>
			<!-- 승인이 안났을 경우에만 교수에게만 보이는 부분-->
			<span><b>상태 :</b> <c:if test="${ not empty teamList.teams && teamList.isPermission == 1 }">승인</c:if>
							  <c:if test="${ not empty teamList.teams && teamList.isPermission == 0 }">거부</c:if> </span>
			<span><b>리더 :</b> ${ teamList.leaderId }</span>
			
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
			<c:if test="${ not empty teamList.teams && teamList.isPermission == 0 }">
				<a href="team/managetm.do?cmd=pm&pm=1&bid=${ teamList.boardCodeId }&tid=${ teamList.teamCodeId }" class="btn btn-default pull-right">승인</a>
			</c:if>
			<c:if test="${ not empty teamList.teams && teamList.isPermission == 1 }">
				<a href="team/managetm.do?cmd=pm&pm=0&bid=${ teamList.boardCodeId }&tid=${ teamList.teamCodeId }" class="btn btn-default pull-right">거부</a>
			</c:if>
		</sec:authorize>
		</div>
	</div>
	<hr>
	<div class="manage-content">
		<form action="mail/send.do" method="post">		
		<table class="table table-striped table-condensed table-hover">
			<thead>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>학과</td>
					<td>연락처</td>
					<td>이메일</td>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
					<td>선택란</td>
					</sec:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" varStatus="idx" items="${ teamList.teams }" >
				<tr ng-controller="ShowHideCtrl" ng-init="init('${ team.userId }')" >
					<td>${ idx.count }</td>
					<td>${ team.userId }</td>
					<td>${ team.userName }</td>
					<td>${ team.department }</td>
					<td>${ team.userTel }</td>
					<td>${ team.userEmail }</td>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
					<td><input type="checkbox" ng-model="confirmed" ng-change="change()" /><input type="hidden" name="userId" value="{{ item }}" /></td>
					</sec:authorize>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${ teamList.leaderId == currentUserName }">
			<c:if test="${ not empty teamList.teams && teamList.isPermission == 0 }">
				<a class="btn btn-default pull-right" href="team/addtm.do?tid=${ teamList.teamCodeId }">팀수정</a>
			</c:if>
			<a class="btn btn-default pull-right" href="team/removetm.do?tid=${ teamList.teamCodeId }">팀삭제</a>
		</c:if>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
			<input class="btn btn-default pull-right" type="submit" value="메일보내기" />
		</sec:authorize>
		</form>
	
	</div>
</div>