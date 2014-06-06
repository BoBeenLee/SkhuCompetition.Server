<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="managecpt">
	<form class="form-inline" action="mypage/managecpt.do" method="get">
		<label for="inputType" class="control-label">대회명 : </label> <select name="bid"
			id="inputType" class="form-control input-sm">
			<c:forEach var="boardCode" items="${ boardCodeList }">
				<option value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
			</c:forEach>
		</select> <input class="form-control btn btn-default input-sm" type="submit"
			value="조회" />
	</form>
	<hr>
	<div class="score">
		<div class="score-pro">
			<form class="form-inline">
				<label for="inputScoreRank" class="control-label">순서 : </label> <input
					id="inputScoreRank" type="text" class="form-control input-sm" /> <label
					for="inputScoreName" class="control-label">상이름 : </label> <input
					id="inputScoreName" type="text" class="form-control input-sm" /> <label
					for="inputScoreContent" class="control-label">상내역 : </label> <input
					id="inputScoreContent" type="text" class="form-control input-sm" />
				<input class="btn btn-default input-sm" type="submit" value="추가" />
			</form>
			<hr>
			<div class="scoreList">
				<table class="table table-striped table-condensed table-hover">
					<thead>
						<tr>
							<th>순서</th>
							<th>상이름</th>
							<th>상내력</th>
							<th>팀지정</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="scoreCode" varStatus="idx" items="${ scoreCodeList }">
						<tr>
							<td>${ idx.count }</td>
							<td>${ scoreCode.scoreName }</td>
							<td>${ scoreCode.content }</td>
							<td><input class="btn btn-default input-sm" type="button"
								value="팀선택" /><input type="text" class="input-sm" value="${ scoreCode.teamName }" /></td>
							<td><a href="#" class="btn btn-default input-sm" >삭제</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<input class="btn btn-default input-sm" type="button" value="저장" />
			</div>
		</div>
		<hr>
		<!-- 학생  -->
		<div class="score-stu scoreList">
			<table class="table table-striped table-condensed table-hover">
				<thead>
					<tr>
						<th>상이름</th>
						<th>상내력</th>
						<th>팀명</th>
						<th>점수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="scoreCode" varStatus="idx" items="${ scoreCodeList }">
					<tr>
						<td>${ scoreCode.scoreName }</td>
						<td>${ scoreCode.content }</td>
						<td>${ scoreCode.teamName }</td>
						<td>${ scoreCode.sum }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div ng-controller="OpenWindowCtrl" class="valuer">
		<div class="form-group">
			<input type="button" ng-click="popup('findUsers.do')"
				class="btn btn-default input-sm" value="평가자찾기" />
		</div>
		<form action="mypage/saveValuer.do" method="post">
			<div class="valuerList">
				<!-- 평가자 명단을 어떻게 불러올 것인가?? -->
				<ul>
					<li ng-repeat="item in itemList"><input type="hidden"
						name="valuerList" value="{{ item.itemId }}" /> 아이디 : {{
						item.itemId }} - 이름 : {{ item.itemName }}</li>
				</ul>
			</div>
			<input type="submit" class="btn btn-default input-sm" value="저장" />
		</form>
	</div>
</div>