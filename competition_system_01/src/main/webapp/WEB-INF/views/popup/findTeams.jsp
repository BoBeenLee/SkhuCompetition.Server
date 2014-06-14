<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="findTeams">
	<table ng-controller="ReturnCtrl" class="table table-striped table-hover">
		<thead>
			<tr>
				<td>팀이름</td>
				<td>리더</td>
				<td>점수</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="teamCode" items="${ teamCodeList }">
			<tr ng-click="setParent('${ teamCode.teamCodeId }', '${ teamCode.teamName }')">
				<td>${ teamCode.teamName }</td>
				<td>${ teamCode.leaderId }</td>
				<td> </td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>