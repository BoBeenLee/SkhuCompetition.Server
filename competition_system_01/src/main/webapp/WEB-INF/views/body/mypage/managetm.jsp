<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="managetm">
	<form class="form-inline">
		<select class="form-control input-sm">
			<option>대회1</option>
			<option>대회2</option>
		</select> <select class="form-control input-sm">
			<option>팀1</option>
			<option>팀2</option>
		</select> <input class="form-control btn btn-default input-sm" type="submit"
			value="조회" />
		<!-- 승인이 안났을 경우에만 교수에게만 보이는 부분-->
		<label class="control-label">상태 : 거부</label>
		<input class="btn btn-default input-sm pull-right" type="button"
			value="승인" /> <input class="btn btn-default input-sm pull-right"
			type="button" value="거부" />
			
		<!-- 팀  삭제 -->
		<input class="btn btn-default input-sm pull-right" type="button" value="팀 삭제" />
	</form>
	<hr>
	<div>
		<table class="table table-striped table-condensed table-hover">
			<thead>
				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>학과</td>
					<td>연락처</td>
					<td>이메일</td>
					<td>선택란</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>아이디1</td>
					<td>이름1</td>
					<td>소프1</td>
					<td>연락처1</td>
					<td>이메일1</td>
					<td><input type="checkbox" /></td>
				</tr>
			</tbody>
		</table>
		<input class="btn btn-default input-sm pull-right" type="button" value="메일보내기" />
	</div>
</div>