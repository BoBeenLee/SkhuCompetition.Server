<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<link rel="stylesheet/less" type="text/css" href="css/common/sub1.less">

<div class="content row">
	<c:if test="${ not empty subTitle }">
	<div class="content-header">
		<h4>${ subTitle }</h4>
	</div>
	</c:if>
	<div class="content-body">
		<tiles:insertAttribute name="content" />
	</div>
</div>