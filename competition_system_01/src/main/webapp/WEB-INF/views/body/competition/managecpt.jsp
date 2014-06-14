<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="managecpt">
	<form class="form-inline" action="competition/managecpt.do" method="get">
		<label for="inputType" class="control-label">대회명 : </label> <select name="bid"
			id="inputType" class="form-control input-sm">
			<option></option>
			<c:forEach var="boardCode" items="${ boardCodeList }">
				<option <c:if test="${ boardCode.boardCodeId == param.bid }">selected="selected"</c:if> value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
			</c:forEach>
		</select> <input class="form-control btn btn-default" type="submit"
			value="조회" />
	</form>
	<hr>
	<div class="score">
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
		<div class="score-pro">
			<form class="form-inline" action="competition/managecpt.do?cmd=add" method="post">
				<label for="inputScoreRank" class="control-label">순서 : </label> <input
					id="inputScoreRank" name="rank" type="text" class="form-control input-sm" /> <label
					for="inputScoreName" class="control-label">상이름 : </label> <input
					id="inputScoreName" name="scoreName" type="text" class="form-control input-sm" /> <label
					for="inputScoreContent" class="control-label">상내역 : </label> <input
					id="inputScoreContent" name="content" type="text" class="form-control input-sm" />
					<input type="hidden" name="boardCodeId" value="${ scoreCodeList.boardCodeId }" />
				<input class="btn btn-default" type="submit" value="추가" />
			</form>
			<hr>
			<div class="scoreList">
				<form:form action="competition/managecpt.do?cmd=modify" method="post" commandName="scoreCodeList">
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
						<c:forEach var="scoreCode" varStatus="idx" items="${ scoreCodeList.scoreCodes }">
						<tr>				
							<td>${ idx.count }<form:hidden path="scoreCodes[${ idx.index }].scoreCodeId"/></td>
							<td>${ scoreCode.scoreName }<form:hidden path="scoreCodes[${ idx.index }].scoreName"/></td>
							<td>${ scoreCode.content }<form:hidden path="scoreCodes[${ idx.index }].content"/></td>
							<td>	
							<form:select path="scoreCodes[${ idx.index }].teamCodeId">					
								<option value="0"></option>
								<c:forEach var="teamCode" items="${ teamCodeList }">
									<option <c:if test="${ teamCode.teamCodeId == scoreCode.teamCodeId }">selected="selected"</c:if> value="${ teamCode.teamCodeId }">${ teamCode.teamName }</option>
								</c:forEach>
							</form:select>								</td>
							<td><a href="competition/managecpt.do?cmd=remove&bid=${ scoreCode.boardCodeId }&scid=${ scoreCode.scoreCodeId }" class="btn btn-default" >삭제</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<form:hidden path="boardCodeId" />
				<input class="btn btn-default" type="submit" value="저장" />
				</form:form>
			</div>
		</div>
		</sec:authorize>
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
					<c:forEach var="scoreCode" varStatus="idx" items="${ scoreCodeList.scoreCodes }">
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
		<div ng-controller="OpenWindowCtrl" class="valuer" 
		ng-init="init([
			<c:forEach var="valuer" varStatus="idx" items="${ valuerList }">
			{
				itemId : '${ valuer.userId }',
				itemName : '${ valuer.userName }'
			}
			<c:if test="${ !idx.last }">, </c:if>
			</c:forEach>  
		])"	>
		<h5>평가자 명단</h5>
		<form action="competition/saveValuer.do" method="post">
			<div class="valuerList">
				<!-- 평가자 명단을 어떻게 불러올 것인가?? -->
				<ul>
					<li ng-repeat="item in itemList"><input type="hidden"
						name="valuerList" value="{{ item.itemId }}" /> 아이디 : {{
						item.itemId }} - 이름 : {{ item.itemName }}
						<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
						<input type="button" ng-click="removeItem($index)" class="btn" value="삭제" />
						</sec:authorize>
					</li>
				</ul>
			</div>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
			<div class="form-group">
				<input type="button" ng-click="popup('findUsers.do')"
					class="btn btn-default" value="평가자찾기" />
				<input type="hidden" name="bid" value="${ param.bid }" />
				<input type="submit" class="btn btn-default" value="저장" />
			</div>
		</sec:authorize>
		</form>
	</div>
	</div>
</div>