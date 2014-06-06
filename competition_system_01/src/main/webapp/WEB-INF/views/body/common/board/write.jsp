<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="write">
	<!-- datepicker -->
	<script type="text/javascript"
		src="js/calendar/jquery.timepicker.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="css/calendar/jquery.timepicker.css" />

	<script type="text/javascript"
		src="js/calendar/bootstrap-datepicker.js"></script>
	<link rel="stylesheet" type="text/css"
		href="css/calendar/bootstrap-datepicker.css" />

	<form:form class="form-horizontal"
		action="${ boardType }/article/write.do" method="post" enctype="multipart/form-data" commandName="articleView">
		<div class="form-group">
			<label for="inputTitle" class="col-md-1 control-label">제목 : </label>
			<div class="col-md-11">
				<form:input path="title" class="title form-control" id="inputTitle"
					placeholder="제목" />
			</div>
		</div>
		<div class="form-group">
			<form:textarea id="editor" class="ckeditor form-control"
				path="contentView" />
		</div>
		<div class="form-group">
			<input class="btn" type="submit" value="확인" /> 
			<input type="hidden" name="mf" value="${ mf }" />
			<form:hidden path="articleId" />
			<a
				href="${ boardType }/board.do?${ pagination }&pg=${ pagination.currentPage}"
				class="btn">취소</a>
		</div>
		<div class="file">
			<form:input type="file" path="uploadfile" />
		</div>
		<div class="notice datepair form-inline" ng-controller="CollapseCtrl">
			<label>공지 : </label> <form:checkbox path="isNoticeView" value="false"
				ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<form:input type="text" path="startPeriodView" class="datepair-date form-control input-sm" placeholder="start" /> - <form:input
					type="text" path="endPeriodView" class="datepair-date form-control input-sm" placeholder="end" />
			</div>
		</div>
		<div class="isFile datepair form-inline" ng-controller="CollapseCtrl">
			<label>파일제출여부 : </label> <form:checkbox path="isFileView" value="false"
				ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<label>제출기한</label>
				<form:input type="text" path="fileLimitDateView" class="datepair-date form-control input-sm" placeholder="end" />
			</div>
		</div>
		<div class="isPassword form-inline" ng-controller="CollapseCtrl">
			<label>비밀번호 설정여부 : </label> <input type="checkbox" ng-click="isCollapsed = !isCollapsed" />
			<div collapse="isCollapsed">
				<label>비밀번호</label>
				<form:password path="password" class="form-control input-sm" placeholder="password" />
			</div>
		</div>
		<form:hidden path="writerId" />
		<form:hidden path="boardCodeId" />
		<form:hidden path="authId" />
	</form:form>

	<script>
		$('.datepair .datepair-date').datepicker({
			'format' : 'yyyy-m-d',
			'autoclose' : true
		});

		// initialize datepairs
		$('.datepair').datepair();
	</script>
</div>