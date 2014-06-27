<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="main.less">
<link rel="stylesheet/less" type="text/css" href="common.less">

<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css"
	rel='stylesheet' />
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css"
	rel='stylesheet' media='print' />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script src="//code.jquery.com/jquery.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>
<style type="text/css">
</style>
<script type="text/javascript">
	jQuery(document).ready(function() {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		$('#calendar').fullCalendar({
			editable : false,
			events : [ {
				title : 'All Day Event',
				start : new Date(y, m, 1)
			}, {
				title : 'Long Event',
				start : new Date(y, m, d - 5),
				end : new Date(y, m, d - 2)
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d - 3, 16, 0),
				allDay : false
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d + 4, 16, 0),
				allDay : false
			}, {
				title : 'Meeting',
				start : new Date(y, m, d, 10, 30),
				allDay : false
			}, {
				title : 'Lunch',
				start : new Date(y, m, d, 12, 0),
				end : new Date(y, m, d, 14, 0),
				allDay : false
			}, {
				title : 'Birthday Party',
				start : new Date(y, m, d + 1, 19, 0),
				end : new Date(y, m, d + 1, 22, 30),
				allDay : false
			}, {
				title : 'Click for Google',
				start : new Date(y, m, 28),
				end : new Date(y, m, 29),
				url : 'http://google.com/'
			} ]
		});
	});
</script>

<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">
</head>
<body class="test">
	<div class="container">
		<div class="header row">
			<span class="main-title">IT Competition System</span> <a
				class="box box-link btn btn-default btn-xs pull-right">링크</a> <a
				class="box box-login btn btn-default btn-xs pull-right">회원가입</a> <a
				class="box box-register btn btn-default btn-xs pull-right">로그인</a>
		</div>
		<div class="menu row">
			<ul class="box-menu nav nav-pills nav-justified">
				<li><a href="notice.do">공지사항</a></li>
				<li><a href="competition.do">경진대회</a></li>
				<li><a href="data.do">대회자료</a></li>
				<li><a href="qa.do">QA</a></li>
			</ul>
		</div>
		<div class="content row">
			<div class="col-md-4">
				<div class="box box-board col-md-12 row">
					<h4>공지사항</h4>
					<ul>
						<li><a href="#"> Notice 1 </a></li>
						<li><a href="#"> Notice 2 </a></li>
						<li><a href="#"> Notice 3 </a></li>
						<li><a href="#"> Notice 4 </a></li>
					</ul>
				</div>
				<div class="box box-board col-md-12 row">
					<h4>경진대회</h4>
					<ul>
						<li><a href="#"> Competition 1 </a></li>
						<li><a href="#"> Competition 2 </a></li>
						<li><a href="#"> Competition 3 </a></li>
						<li><a href="#"> Competition 4 </a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-8">
				<div class="box box-calendar">
					<div id="calendar"></div>
				</div>
			</div>
		</div>
		
		<div class="footer row">
			<p>
				서울시 구로구 항동 1-1 성공회대학교 (152-716) Tel : 02.2610.4334 Fax :
				02.2610.4330 문의 : swadmin@skhu.ac.kr<br>copyright 2014 (c)
				sungkonghoe univ. software egineering dept. Bobin Lee. All rights
				reserved.
			</p>
		</div>
	</div>
</body>
</html>