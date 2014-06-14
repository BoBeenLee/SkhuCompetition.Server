<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="addcpt">
	<form:form class="form-horizontal" action="competition/addcpt.do"
		method="post" commandName="boardCodeView">
		<div class="form-group">
			<label for="inputComName" class="col-md-3 control-label">대회명
				: </label>
			<div class="col-md-5">
				<form:input path="boardName" type="text" id="inputComName"
					class="form-control" />
			</div>
			<form:hidden path="builderId" />
			<form:hidden path="boardType" />
			<form:hidden path="isHidden" />
			<form:hidden path="parentBoardCodeId" />
		</div>
		<input type="submit" class="btn btn-default col-md-offset-3" value="확인" />
	</form:form>
	<hr />
	<form class="form-horizontal" action="competition/hiddencpt.do" method="post">
		<div class="form-group">
			<label for="inputType" class="col-md-3 control-label">대회명 : </label>
			<div class="col-md-4">
				<select id="inputType" name="boardCodeId" class="form-control">
					<c:forEach var="boardCode" items="${ boardCodeList }">
						<option value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<select id="inputType" name="isHidden" class="form-control">
					<option value="0">보이기</option>
					<option value="1">감추기</option>
				</select>
			</div>
		</div>
		<input class="btn btn-default col-md-offset-3" type="submit" value="확인" />
	</form>
</div>