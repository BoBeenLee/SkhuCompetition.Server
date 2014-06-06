<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="managetm">
	<form class="form-horizontal" action="mypage/addtm.do" method="post">
		<div class="form-group">
			<label for="inputType" class="col-md-3 control-label">구분 : </label>
			<div class="col-md-5">
				<select id="inputType" name="boardCodeId" class="form-control">
					<c:forEach var="boardCode" items="${ boardCodeList }">
						<option value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="inputTeamName" class="col-md-3 control-label">팀명
				: </label>
			<div class="col-md-5">
				<input id="inputTeamName" name="teamName" class="form-control"
					type="text" placeholder="팀명" />
			</div>
		</div>
		<div class="form-group">
			<label for="inputTeamContent" class="col-md-3 control-label">팀
				내용 : </label>
			<div class="col-md-5">
				<textarea id="inputTeamContent" name="teamContent"
					class="form-control">팀 내용을 적어주세요.</textarea>
			</div>
		</div>
		<!-- 팀원은 추가하는 방식으로  -->
		<hr>
		<div class="form-group">
			<label for="inputTeamContent" class="col-md-3 control-label">
				팀장 : 나 </label>
		</div>
		<hr>
		<div ng-controller="OpenWindowCtrl" class="form-group">
			<label for="inputTeamContent" class="col-md-3 control-label">
				팀원 </label>
			<input type="button" ng-click="popup('findUsers.do')"
				class="btn btn-default input-sm" value="찾기" />
			<div class="teamList">
				<!-- 평가자 명단을 어떻게 불러올 것인가?? -->
				<ul>
					<li ng-repeat="item in itemList"><input type="hidden"
						name="teamList" value="{{ item.itemId }}" />이름 : {{ item.itemName
						}}</li>
				</ul>
			</div>
		</div>
		<hr>
		<div class="form-group">
			<input type="submit" class="btn col-md-offset-3" value="확인" />
		</div>
	</form>
</div>