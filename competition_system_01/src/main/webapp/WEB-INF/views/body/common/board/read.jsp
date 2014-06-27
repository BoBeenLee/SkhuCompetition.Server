<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet/less" type="text/css"
	href="css/common/article.less">

<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
<sec:authentication property="name" var="currentUserName"/>

<div class="read">
	<div class="read-header">
		<h4 class="panel-title">
			${ article.title }
			 <small class="pull-right">
			 <span class="glyphicon glyphicon-calendar"></span>
				작성자: ${ article.writerId } 작성일 : ${ article.writtenDate } / 조회 : ${ article.hit }</small>			
		</h4>
	</div>
	<div class="read-content">
		<div>
		<c:forEach var="file" items="${ articleFile }">
			<a href="fileDown.do?fi=${ file.fileId }">${ file.fileName }</a>
		</c:forEach>
		</div>
		<p>${ article.contentView }</p>
	</div>	
	<jsp:useBean id="now" class="java.util.Date"/>	
	<c:if test="${isTeam && (article.isFile == 1) && (empty article.fileLimitDate || now <= article.fileLimitDate)}">
		<hr>
		<form class="form-horizontal" action="${ boardType }/article/uploadfile.do" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputFile" class="col-md-2 control-label">파일  :</label>
				<div class="col-md-2">
					<input id="inputFile" type="file" name="uploadfile" />
				</div>
				<input type="hidden" name="ai" value="${ article.articleId }" />
				<input type="hidden" name="bid" value="${ pagination.bid }" />
				<input type="hidden" name="sz" value="${ pagination.sz }" />
			</div>
			<div class="form-group" ng-controller="TagCtrl" >
				<label for="inputTag" class="col-md-2 control-label">태그 :</label>
				<div class="col-md-2">
					<input id="inputTag" ng-model="tag" class="form-control input-sm" type="text" placeholder="태그명"  />
				</div>
				<a ng-click="addTag()" class="btn btn-default btn-sm">추가</a>
				<span ng-repeat="tag in tagList">
					{{ tag }} 
					<input name="tagName" type="hidden" value="{{ tag }}" /> 
					<a ng-click="removeTag($index)" class="btn btn-default btn-sm">X</a>
				</span>
			</div>
			<div class="form-group">
				<input class="btn btn-default col-md-1 col-md-offset-1" type="submit" value="제출" />
			</div>
		</form>
	</c:if>
	
	<c:if test="${ not empty fileList }">
	<hr>
	<div class="user-file">
		<label>제출 파일</label>
		<ul>
		<c:forEach var="file" items="${ fileList }">
			<li><span>팀 : ${ file.teamName } - </span><a href="fileDown.do?fi=${ file.fileId }">${ file.fileName }</a>
			<span>
			태그 : 
			<c:forEach var="tag" items="${ file.tagList }">
				<a class="btn btn-default btn-sm">${ tag.tagName }</a>
			</c:forEach>
			</span>
			</li>			
		</c:forEach>
		</ul>
	</div>
	</c:if>
	<div class="read-comment">
		<jsp:include page="comment.jsp"></jsp:include>
	</div>
	<hr>
	<div class="read-option">
	<c:if test="${ article.writerId == currentUserName || isAdmin}">
	
		<c:if test="${ article.isShare == 1 }">
			<a class="btn btn-default" href="${ boardType }/article/modifyShare.do?${ pagination }&ai=${ article.articleId }&is=0">공유 취소</a>
		</c:if>
		<c:if test="${ article.isShare == 0 && parentBoardCodeId == 2 }">
			<a class="btn btn-default" href="${ boardType }/article/modifyShare.do?${ pagination }&ai=${ article.articleId }&is=1">대회자료 공유</a>
		</c:if>
		<a class="btn btn-default" href="${ boardType }/article/write.do?${ pagination }&ai=${ article.articleId }">수정</a>
		<a class="btn btn-default" href="${ boardType }/article/remove.do?${ pagination }&ai=${ article.articleId }">삭제</a>
	</c:if>
		<a href="${ boardType }/board.do?${ pagination }&pg=${ pagination.currentPage }" class="btn btn-default pull-right"><img src="image/common/list.png" /> 목록</a>
	</div>
</div>
