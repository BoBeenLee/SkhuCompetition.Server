<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- editor -->
<script src="css/ckeditor/ckeditor.js"></script>

<!-- datepicker -->
<script type="text/javascript"
	src="js/calendar/jquery.timepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/calendar/jquery.timepicker.css" />

<script type="text/javascript"
	src="js/calendar/bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/calendar/bootstrap-datepicker.css" />

<link rel="stylesheet/less" type="text/css"
	href="css/common/article.less">

<div class="write">
	<form:form class="form-horizontal" ng-controller="DatepickerCtrl" ng-init="init()" 
		action="${ boardType }/article/write.do" method="post" enctype="multipart/form-data" commandName="articleView">
		<div class="form-group">
			<label for="inputTitle" class="col-md-1 control-label text-left">제목 : </label>
			<div class="col-md-11">
				<form:input path="title" class="title form-control" id="inputTitle"
					placeholder="제목" />
			</div>
		</div>
		<div class="form-group editor">
			<form:textarea id="editor" class="ckeditor form-control"
				path="contentView" />
		</div>
		<div class="file form-group">
			<form:input type="file" path="uploadfile" />
		</div>
		<div class="notice datepair form-group" ng-controller="CollapseCtrl">
			<label>공지 : </label> <form:checkbox path="isNoticeView" value="false"
				ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<form:input type="text" path="startPeriodView" class="datepair-date form-control input-sm" placeholder="start" /> - <form:input
					type="text" path="endPeriodView" class="datepair-date form-control input-sm" placeholder="end" />
			</div>
		</div>
		<c:if test="${ boardCodeView.parentBoardCodeId == 2 }">
		<div class="isFile datepair form-group" ng-controller="CollapseCtrl">
			<label>파일제출여부 : </label> <form:checkbox path="isFileView" value="false"
				ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<label>제출기한</label>
				<input type="text" class="datepair-date limitdate form-control input-sm" value="${ articleView.fileLimitDateView }" placeholder="end" />
				<input type="text" class="timepair limittime form-control input-sm" placeholder="time" />
				<form:hidden path="fileLimitDateView" value="{{ limitDate + ' ' + limitTime }}"/>
			</div>
		</div>
		</c:if>
		<div class="isPassword form-group" ng-controller="CollapseCtrl">
			<label>비밀번호 설정여부 : </label> <input type="checkbox" ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<label>비밀번호</label>
				<form:password path="password" class="form-control input-sm" placeholder="password" />
			</div>
		</div>
		<div class="write-btn form-group">
			<button class="btn" type="submit">
				<img src="image/common/check.png" />
				확인
			</button>
			<input type="hidden" name="mf" value="${ mf }" />
			<form:hidden path="articleId" />
			<a
				href="${ boardType }/board.do?${ pagination }&pg=${ pagination.currentPage}"
				class="btn"><img src="image/common/cancel.png" /> 
				취소
			</a>
		</div>
		<input type="hidden" name="is" value="${ pagination.is }" />
		<input type="hidden" name="bid" value="${ pagination.bid }" />
		<input type="hidden" name="sz" value="${ pagination.sz }" />
		<form:hidden path="writerId" />
		<form:hidden path="boardCodeId" />
	</form:form>
</div>