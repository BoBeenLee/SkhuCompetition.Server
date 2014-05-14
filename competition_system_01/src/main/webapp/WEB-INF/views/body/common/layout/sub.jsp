<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="content row">
	<div class="content-sub col-md-3">
		<h4>경진대회</h4>
		<ul class="list-group">
			<li class="list-group-item"><a class="btn btn-default" href="#">IT
					경진대회</a></li>
			<li class="list-group-item"><a class="btn btn-default" href="#">IT
					경진대회</a></li>
			<li class="list-group-item"><a class="btn btn-default" href="#">IT
					경진대회</a></li>
			<li class="list-group-item"><a class="btn btn-default" href="#">IT
					경진대회</a></li>
		</ul>
		<hr>
	</div>
	<div class="content-main col-md-9">
		<div class="content-header">
			<h4>IT 경진대회11</h4>
		</div>
		<div class="content-body">
			<tiles:insertAttribute name="content" />
		</div>
	</div>

</div>