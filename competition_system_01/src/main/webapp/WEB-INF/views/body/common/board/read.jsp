<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="read">
	<div class="read-header">
		<h4 class="panel-title">
			${ article.title }
			 <small class="pull-right"><span class="glyphicon glyphicon-calendar"></span>
				작성자: ${ article.writerId } 작성일 : ${ article.writtenDate } / 조회 : ${ article.hit }</small>
		</h4>
	</div>
	<div class="read-content">
		<div>
		<c:forEach var="file" items="${ articleFile }">
			<a href="fileDown.do?fi=${ file.fileId }">${ file.fileName }</a>
		</c:forEach>
		</div>
		${ article.contentView }
	</div>
	<jsp:useBean id="now" class="java.util.Date"/>
	
	<c:if test="${(article.isFile == 1) && (empty article.fileLimitDate || now <= article.fileLimitDate)}">
		<form class="form-inline" action="${ boardType }/article/uploadfile.do" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputFile" class="control-label">파일 제출 : </label>
				<input id="inputFile" class="form-control" type="file" name="uploadfile" />
			</div>
			<div class="form-group">
				<input type="hidden" name="ai" value="${ article.articleId }" />
				<input type="hidden" name="bid" value="${ pagination.bid }" />
				<input type="hidden" name="sz" value="${ pagination.sz }" />
				<input class="btn" type="submit" value="제출" />
			</div>
		</form>
	</c:if>
	<c:if test="${ not empty fileList }">
	<div class="user-file">
		<label>제출 파일</label>
		<ul>
		<c:forEach var="file" items="${ fileList }">
			<li><a href="fileDown.do?fi=${ file.fileId }">${ file.fileName }</a></li>
		</c:forEach>
		</ul>
	</div>
	</c:if>
	<div class="read-comment">
		<jsp:include page="comment.jsp"></jsp:include>
	</div>
	<div class="read-option">
		<a class="btn btn-default input-sm" href="${ boardType }/article/write.do?${ pagination }&ai=${ article.articleId }">수정</a><a class="btn btn-default input-sm" href="${ boardType }/article/remove.do?${ pagination }&ai=${ article.articleId }">삭제</a>
	</div>
</div>
