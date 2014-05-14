<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="sub.less">
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

<script type="text/javascript">
	jQuery(document).ready(function() {

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
			<div class="content-sub col-md-3">
				<h4>경진대회</h4>
				<ul class="list-group">
					<li class="list-group-item"><a class="btn btn-default" href="#">IT 경진대회</a></li>
					<li class="list-group-item"><a class="btn btn-default" href="#">IT 경진대회</a></li>
					<li class="list-group-item"><a class="btn btn-default" href="#">IT 경진대회</a></li>
					<li class="list-group-item"><a class="btn btn-default" href="#">IT 경진대회</a></li>
				</ul>
				<hr>
			</div>
			<div class="content-body col-md-9">
				<div class="body-header col-md-12 row">
					<h4>IT 경진대회</h4>
				</div>
				<div class="body-content col-md-12 row"></div>
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