<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>
<link rel="stylesheet/less" type="text/css" href="main.less">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="//code.jquery.com/jquery.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>
<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">
</head>
<body class="test">
	<div class="container">
		<div class="header row">
			<span class="main-title">Skhu IT 경진대회</span> <a type="button"
				class="box box-link btn btn-default btn-xs pull-right">링크</a> <a
				type="button"
				class="box box-login btn btn-default btn-xs pull-right">회원가입</a> <a
				type="button"
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
				<div class="box box-notice">
					Notice
					<div>
						<table>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
							<tr><td>test</td></tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="box box-board">Board</div>
			</div>
			<div class="col-md-3">
				<div class="box box-calendar">Calendar</div>
			</div>
		</div>
		<div class="footer row">Footer</div>
	</div>
</body>
</html>