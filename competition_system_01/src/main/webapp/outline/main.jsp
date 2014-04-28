<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="//code.jquery.com/jquery.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>
<style type="text/css">
.container {
	margin-top: 50px;
}

/* header */
.header {
	height: 170px;
	background-color: #991;
}

.box-login {
	top: 5%;
}

.box-register {
	top: 5%;
}

/* menu */
.menu {
	padding: 1%;
}

/* content */
.content {
	height: 550px;
}

/* Box - Notice, Rank */
.content div.col-md-4:nth-of-type(1) {
	height: 100%;
}

.box-notice {
	height: 50%;
	background-color: #983;
	padding: 5%;
}

.box-rank {
	height: 50%;
	background-color: #985;
	padding: 5%;
}

/* Box - Quick, Calendar */
.content div.col-md-4:nth-of-type(2) {
	height: 100%;
}

.box-quick {
	height: 50%;
	background-color: #987;
	padding: 5%;
}

.box-calendar {
	height: 50%;
	background-color: #989;
	padding: 5%;
}

/* Box - Picturer */
.content div.col-md-4:nth-of-type(3) {
	height: 100%;
}

.box-pic {
	height: 100%;
	background-color: #980;
	padding: 5%;
}

/* footer */
.footer {
	height: 150px;
	background-color: #995;
	padding: 5%;
}
</style>
<body>
	<div class="container">
		<div class="header row">
			Title
			<button type="button" class="btn btn-default pull-right">Register</button>
			<button type="button" class="btn btn-default pull-right">Login</button>
		</div>
		<div class="menu">
			<ul class="nav nav-pills nav-justified">
				<li><a href="#">Home</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Messages</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Messages</a></li>
			</ul>
		</div>
		<div class="content row">
			<div class="col-md-4">
				<div class="row box-notice">Notice</div>
				<div class="row box-rank">Rank</div>
			</div>
			<div class="col-md-4">
				<div class="row box-quick">Quick</div>
				<div class="row box-calendar">Calendar</div>
			</div>
			<div class="col-md-4">
				<div class="row box-pic">Picture</div>
			</div>
		</div>
		<div class="footer row">Footer</div>
	</div>
</body>
</html>