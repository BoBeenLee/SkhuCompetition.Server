<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="board">
	<div class="board-content">
		<table class="table table-striped table-condensed table-hover">
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
				<button class="form-control btn btn-default input-sm" type="button">Go!</button>
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
			<button class="btn btn-default input-sm" type="button">글쓰기</button>
		</div>
	</div>
</div>
