<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="board.less">
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
			<div class="board">
				<div class="board-content">
					<table class="table table-condensed table-hover">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>날짜</th>
								<th>조회</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><a href="#">아녕하세요 안녕하세요 안녕.</a></td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">아녕하요 안녕.</a></td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">아녕하세요 안녕하세요 안녕.</a></td>
								<td>이보dd빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">아녕하세요 안녕하세요 안녕.</a></td>
								<td>이보빈</td>
								<td>01-01</td>
								<td>1422</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="board-menu">
					<div class="board-search pull-left">
						<form class="form-inline" role="form">
							<select class="form-control input-sm">
								<option>1</option>
								<option>2</option>
								<option>3</option>
							</select> <input type="text" class="form-control input-sm" />
							<button class="form-control btn btn-default btn-md"
								type="button">Go!</button>
						</form>
					</div>
					<div class="board-page-list">
						<ul class="pagination">
							<li><a href="#">«</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">»</a></li>
						</ul>
					</div>
					<div class="board-write pull-right">
						<button class="btn btn-default btn-md" type="button">글쓰기</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>