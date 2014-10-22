<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="team.less">
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
			<div class="team col-md-12">
				<div class="team-content row">
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<th>체크박스</th>
								<th>대회명</th>
								<th>팀명</th>
								<th>팀타입</th>
								<th>팀생성날짜</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" /></td>
								<td>아녕하세요 안녕하세요 안녕.</td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>아녕하요 안녕.</td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>아녕하세요 안녕하세요 안녕.</td>
								<td>이보dd빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td><input type="checkbox" /></td>
								<td>아녕하세요 안녕하세요 안녕.</td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="team-menu row">
					<button class="btn btn-default btn-md pull-right" type="button">변경</button>
					<button class="btn btn-default btn-md pull-right" type="button">신청</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>