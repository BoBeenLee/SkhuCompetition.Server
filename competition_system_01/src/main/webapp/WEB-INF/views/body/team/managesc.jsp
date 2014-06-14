<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="managesc">
	<div ng-controller="BidToTidCtrl" ng-init="init('${ scoreList.boardCodeId }', '${ scoreList.teamCodeId }', 'team/tclist.do')">
	<form class="form-inline" action="team/managesc.do" method="get">
		<select name="bid" class="form-control input-sm" ng-model="bid" ng-change="getSelectedBid('team/tclist.do')">
			<c:forEach var="boardCode" items="${ boardCodeList }">
				<option value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
			</c:forEach>
		</select> 
		<select name="tid" class="form-control input-sm" ng-model="tid">
			<option ng-repeat="team in teamList" value="{{ team.teamCodeId }}">{{team.teamName}}</option>
		</select>
		<input class="form-control btn btn-default" type="submit"
			value="조회" />
	</form>
	</div>
	<hr>
	<div>
		<form:form action="team/managesc.do?cmd=save" method="post" commandName="scoreList">
		<table class="table table-striped table-condensed table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>제출자</th>
					<th>점수</th>
					<th>파일 URL</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="score" varStatus="idx" items="${ scoreList.scores }">
				<tr>
					<td>${ idx.count }
					<form:hidden path="scores[${ idx.index }].scoreId" />
					<form:hidden path="scores[${ idx.index }].articleId" />
					<form:hidden path="scores[${ idx.index }].teamCodeId" value="${ scoreList.teamCodeId }" />
					</td>
					<td>${ score.title }</td>
					<td>${ score.userId }<form:hidden path="scores[${ idx.index }].userId" /></td>
					<td><form:input path="scores[${ idx.index }].score" class="input-sm" type="text" /></td>
					<td><a href="fileDown.do?fi=${ score.fileId }">${ score.fileName }</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${ isValuer }">
			<input class="btn btn-default pull-right" type="submit" value="확인" />
		</c:if>
		<form:hidden path="boardCodeId" />
		<form:hidden path="teamCodeId" />
		</form:form>
	</div>
	<hr>
	<div>
		<table class="table table-condensed">
			<thead>
				<tr>
					<td>팀명</td>
					<c:forEach var="rank" items="${ rankList }">
					<td>${ rank.name }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>총 순위</td>
					<c:forEach var="rank" varStatus="idx" items="${ rankList }">
					<td>${ idx.count }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>총 합계</td>
					<c:forEach var="rank" items="${ rankList }">
					<td>${ rank.sum }</td>
					</c:forEach>
				</tr>
				<tr>
					<td>총 평균</td>
					<c:forEach var="rank" items="${ rankList }">
					<td>${ rank.average }</td>
					</c:forEach>
				</tr>
			</thead>
		</table>
	</div>
</div>
