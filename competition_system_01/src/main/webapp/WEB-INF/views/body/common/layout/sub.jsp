<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="content row">
	<div class="content-sub col-md-2">
		<ul class="list-group">
			<c:forEach var="page" items="${ pgList }">
				<li class="list-group-item"><a class="btn btn-default" href="${ page.url }">${ page.korName }</a></li>			
			</c:forEach>		
		</ul>
	</div>
	<div class="content-main col-md-10">
		<div class="content-header">
			<h4>${ subTitle }</h4>
		</div>
		<div class="content-body">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
</div>