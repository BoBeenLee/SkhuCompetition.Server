<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- fullcalendar -->
<!-- <link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css"
	rel='stylesheet' />
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css"
	rel='stylesheet' media='print' />
<script
	src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script>	
	   -->
<link
	href="css/calendar/fullcalendar.css"
	rel='stylesheet' />
<link
	href="css/calendar/fullcalendar.print.css"
	rel='stylesheet' media='print' />
<script src="js/calendar/fullcalendar.min.js"></script>

<link rel="stylesheet/less" type="text/css" href="css/main/main.less">

<div ng-controller="CalendarCtrl" class="main row" 
ng-init="init([
 <c:forEach var="calendar" varStatus="idx" items="${ calendarList }">
	{
	    title : '${ calendar.content }',
	    start : '${ calendar.startDateView }',
	    end : '${ calendar.endDateView }'
	} 
 <c:if test="${ !idx.last }">, </c:if>
 </c:forEach>  
])"	>
	<div class="col-md-4">
		
		<div class="box box-board">
			<h4>공지사항</h4>
			<ul>
				<c:forEach var="notice" items="${ noticeList }">
					<li><a href="sub1/article/read.do?bid=${ notice.boardCodeId }&ai=${ notice.articleId }">
							${ notice.title } </a></li>
				</c:forEach>
			</ul>
		</div>		
		<div class="box box-board">
			<h4>경진대회</h4>
			<ul>
				<c:forEach var="competition" items="${ competitionList }">
					<li><a href="sub/article/read.do?bid=${ competition.boardCodeId }&ai=${ competition.articleId }">
							${ competition.title } </a></li>
				</c:forEach>	
			</ul>
		</div>
		<div class="box box-board">
			<h4>QnA</h4>
			<ul>
				<c:forEach var="qna" items="${ qnaList }">
					<li><a href="sub1/article/read.do?bid=${ qna.boardCodeId }&ai=${ qna.articleId }">
							${ qna.title } </a></li>
				</c:forEach>	
			</ul>
		</div>
	</div>
	<div class="col-md-8">
		<div class="box box-calendar">
			<div id="calendar"></div>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESOR')">
				<a href="main/managecal.do" class="btn btn-default">
				<img src="image/main/calendar.png" />
				달력관리
				</a>
			</sec:authorize>
		</div>
	</div>
</div>