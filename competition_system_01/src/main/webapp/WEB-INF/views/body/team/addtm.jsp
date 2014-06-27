<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="managetm">
	<form:form class="form-horizontal" action="team/addtm.do" method="post" commandName="teamCodeView">
		<div class="form-group">
			<label for="inputType" class="col-md-3 control-label">구분 : </label>
			<div class="col-md-5">
				<form:select id="inputType" path="boardCodeId" class="form-control">
					<c:forEach var="boardCode" items="${ boardCodeList }">
						<form:option value="${ boardCode.boardCodeId }" label="${ boardCode.boardName }" />
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputTeamName" class="col-md-3 control-label">팀명
				: </label>
			<div class="col-md-5">
				<form:input id="inputTeamName" path="teamName" class="form-control"
					type="text" placeholder="팀명" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputTeamContent" class="col-md-3 control-label">팀
				내용 : </label>
			<div class="col-md-5">
				<form:textarea id="inputTeamContent" path="teamContent"
					class="form-control" value="팀 내용을 적어주세요." />
				<form:hidden path="teamCodeId"/>
				<form:hidden path="leaderId"/>
				<form:hidden path="teamType"/>
			</div>
		</div>
		<!-- 팀원은 추가하는 방식으로  -->
		<hr>
		<div class="form-group">
			<label class="col-md-3 control-label">
				팀장 : </label>
			<div class="col-md-5">
				<label class="control-label">나</label>
			</div>
		</div>
		<hr>
		<div ng-controller="OpenWindowCtrl" class="form-group" ng-init="init([
			<c:forEach var="team" varStatus="idx" items="${ teamList }">
				{ 
					itemId : '${ team.userId }',
					itemName : '${ team.userName }'
				} 
				<c:if test="${ !idx.last }">, </c:if>
			</c:forEach>
		])">
			<label for="inputTeamContent" class="col-md-3 control-label">
				팀원 </label>
			<input type="button" ng-click="popup('findUsers.do')"
				class="btn btn-default" value="찾기" />
			<hr>
			<div class="teamList col-md-offset-2">
				<!-- 평가자 명단을 어떻게 불러올 것인가?? -->
				<ul>
					<li ng-repeat="item in itemList"><input type="hidden"
						name="teamList" value="{{ item.itemId }}" />이름 : {{ item.itemName }}<input type="button" ng-click="removeItem($index)" class="btn" value="삭제" /></li>
				</ul>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<input type="submit" class="btn btn-default col-md-offset-3" value="확인" />
		</div>
	</form:form>
</div>