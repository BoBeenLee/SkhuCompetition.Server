<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="findTeams">
	<form class="form-inline" action="findTeams.do" method="get">
		<select name="st" class="form-control input-sm">
			<option value="teamName">팀이름</option>
			<option value="leaderId">리더</option>
		</select>
		<input type="text" name="ct" class="form-control input-sm" />
		<input class="form-control btn btn-default input-sm" type="submit" value="검색" />
	</form>
	
	<table ng-controller="ReturnCtrl" class="table table-striped table-hover">
		<thead>
			<tr>
				<td>팀이름</td>
				<td>리더</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="team" items="${ teamList }">
			<tr ng-click="setParent('${ team.teamCodeId }', '${ team.teamName }')">
				<td>${ team.teamName }</td>
				<td>${ team.leaderId }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>