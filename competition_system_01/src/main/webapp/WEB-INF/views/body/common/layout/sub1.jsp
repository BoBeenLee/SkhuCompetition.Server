<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<div class="content row">
	<div class="content-header">
		<h4>${ subTitle }</h4>
	</div>
	<div class="content-body">
		<tiles:insertAttribute name="content" />
	</div>
</div>