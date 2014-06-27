<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="managecal" ng-controller="DatepickerCtrl" ng-init="init()">
	<!-- datepicker -->
	<script type="text/javascript"
		src="js/calendar/jquery.timepicker.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="css/calendar/jquery.timepicker.css" />

	<script type="text/javascript"
		src="js/calendar/bootstrap-datepicker.js"></script>
	<link rel="stylesheet" type="text/css"
		href="css/calendar/bootstrap-datepicker.css" />

	<form:form class="form-inline" action="main/managecal.do"
		method="get" commandName="calendarView1">
		<div class="datepair form-group">
			<form:input path="startDateView"
				class="datepair-date form-control input-sm" placeholder="start" />
			-
			<form:input path="endDateView"
				class="datepair-date form-control input-sm" placeholder="end" />
		</div>
		<input class="form-control btn btn-default" type="submit"
			value="조회" />
	</form:form>
	<hr>
	<div class="calendarList">
		<table class="table table-striped table-condensed table-hover">
			<thead>
				<tr>
					<td>번호</td>
					<td>시작날짜</td>
					<td>마지막날짜</td>
					<td>내용</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="calendar" varStatus="idx" items="${ calendarList }">
					<tr>
						<td>${ idx.count }</td>
						<td>${ calendar.startDateView }</td>
						<td>${ calendar.endDateView }</td>
						<td>${ calendar.content }</td>
						<td><form:form action="main/removeCalendar.do" method="get"
								commandName="calendarView1">
								<form:hidden path="startDateView" />
								<form:hidden path="endDateView" />
								<input type="hidden" name="cId" value="${ calendar.calendarId }" />
								<input class="btn btn-xs" type="submit" value="삭제" />
							</form:form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<form:form class="form-inline" action="main/addCalendar.do"
		method="post" commandName="calendarView2">
		<div class="datepair form-group">
			<form:input path="startDateView"
				class="datepair-date form-control input-sm" placeholder="start" />
			-
			<form:input path="endDateView"
				class="datepair-date form-control input-sm" placeholder="end" />
		</div>
		<form:input path="content" class="form-control input-sm"
			placeholder="내용" />
		<input type="hidden" name="sd" value="${ calendarView1.startDateView }" />
		<input type="hidden" name="ed" value="${ calendarView1.endDateView }" />
		<input class="form-control btn btn-default" type="submit"
			value="추가" />
	</form:form>
</div>