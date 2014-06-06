<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="CalendarCtrl" class="content row">
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
			<div id="calendar"></div>
		</div>
	</div>
</div>