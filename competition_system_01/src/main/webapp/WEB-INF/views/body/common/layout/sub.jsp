<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet/less" type="text/css" href="css/common/sub.less">

<div class="content row">
	<div class="content-sub col-md-3">
		<ul class="list-group">
			<c:forEach var="page" items="${ pgList }">
				<li class="list-group-item"><a href="${ page.url }">
					<c:if test="${ page.url == selectedURI }">
						<img src="image/sub/b_on.png" />
						<span class="selected-sub">${ page.korName }</span>
					</c:if>
					<c:if test="${ page.url != selectedURI }">
						<img src="image/sub/b_off.png" />
						<span>${ page.korName }</span>
					</c:if>
					</a>
				</li>			
			</c:forEach>		
		</ul>
	</div>
	<div class="content-main col-md-9">
		<div class="content-header">
			<h4>${ subTitle }</h4>
		</div>
		<div class="content-body">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
</div>