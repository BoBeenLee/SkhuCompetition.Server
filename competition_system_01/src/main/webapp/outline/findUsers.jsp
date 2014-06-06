<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<div class="findUsers">
	<form class="form-inline">
		<select class="form-control input-sm">
			<option>아이디</option>
			<option>이름</option>
			<option>학과</option>
		</select>
		<input class="form-control input-sm" type="text" value="" />
		<input class="form-control btn btn-default input-sm" type="submit" value="검색" />
	</form>
	
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>학과</td>
			</tr>
		</thead>
		<tbody>
		
			<tr>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>