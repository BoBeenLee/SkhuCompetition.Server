<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="CalendarCtrl" class="content row" 
ng-init="init([
 <c:forEach var="calendar" varStatus="idx" items="${ calendarList }">
	{
	    title : '${ calendar.content }',
	    start : '${ calendar.startDateView }',
	    end : '${ calendar.endDateView }',
	    allDay : false
	} 
 <c:if test="${ !idx.last }">, </c:if>
 </c:forEach>  
])"	>
	<div class="col-md-4">
		<div class="box box-board col-md-12 row">
			<h4>공지사항</h4>
			<ul>
				<c:forEach var="notice" items="${ noticeList }">
					<li><a href="sub1/article/read.do?bid=${ notice.boardCodeId }&ai=${ notice.articleId }">
							${ notice.title } </a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="box box-board col-md-12 row">
			<h4>경진대회</h4>
			<ul>
				<c:forEach var="competition" items="${ competitionList }">
					<li><a href="sub/article/read.do?bid=${ competition.boardCodeId }&ai=${ competition.articleId }">
							${ competition.title } </a></li>
				</c:forEach>	
			</ul>
		</div>
	</div>
	<div class="col-md-8">
		<div class="box box-calendar">
			<a href="main/managecal.do" class="btn btn-default pull-right">달력관리</a>
			<div id="calendar"></div>
		</div>
	</div>
</div>