<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>경진대회 메인</title>

<link rel="stylesheet/less" type="text/css" href="comment.less">
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
<body>
	<div class="container">
		<div class="content row">
			<div class="comment">
				<div class="comment-editor">
					<label>ID</label>
					<textarea></textarea>
					<input type="button" class="btn btn-default pull-right btn-sm" value="덧글달기" />
				</div>
				<div class="comment-modify">
					<div class="controls pull-right">
						<div class="btn-group">
							<a class="btn dropdown-toggle btn-sm" data-toggle="dropdown">편집<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a class="btn btn-default btn-sm" onclick="">덧글 편집하기</a></li>								
								<li><a class="btn btn-default btn-sm"  onclick="">덧글 삭제</a></li>
							</ul>
						</div>
					</div>
					<div class="comment-header">
						<span>2.</span> <span>admin</span> <span>2014-01-15 13:21</span>
					</div>
					<div class="comment-content">덧글 테스트1</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>