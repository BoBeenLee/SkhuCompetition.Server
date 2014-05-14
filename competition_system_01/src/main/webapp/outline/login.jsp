<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="login.less">
<link rel="stylesheet/less" type="text/css" href="common.less">

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
		<div class="content row">
			<div class="login">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputEmail1" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="email" class="form-control" id="inputEmail1"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword1" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" id="inputPassword1"
								placeholder="Password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<button type="submit" class="btn btn-default">Login</button>
							<button type="submit" class="btn btn-default">Register</button>
							<button type="submit" class="btn btn-default">Forget</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>