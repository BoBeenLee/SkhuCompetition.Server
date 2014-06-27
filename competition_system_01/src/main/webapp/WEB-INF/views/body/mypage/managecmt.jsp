<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- autosize -->
<script src="js/common/jquery.autosize.min.js"></script>

<link rel="stylesheet/less" type="text/css"
	href="css/common/comment.less">

<div ng-controller="AutoSizeCtrl" class="maangecmt">
	<form class="comment-header form-inline" action="mypage/managecmt.do" method="get">
		<select name="bid" class="form-control input-sm">
			<c:forEach var="boardCode" items="${ boardCodeList }">
				<c:if test="${ boardCode.boardCodeId == 0 }">
					<option <c:if test="${boardCode.boardCodeId == param.bid}">selected="selected"</c:if> value="${ boardCode.boardCodeId }">대회자료</option>
				</c:if>
				<c:if test="${ boardCode.boardCodeId != 0 }">
					<option <c:if test="${boardCode.boardCodeId == param.bid}">selected="selected"</c:if> value="${ boardCode.boardCodeId }">${ boardCode.boardName }</option>
				</c:if>
			</c:forEach>
		</select> 
		<input class="form-control btn btn-default" type="submit"
			value="조회" />
	</form>
	<div class="comment-content">
		<c:set var="articleId" value="-1" />
		<c:forEach var="comment" varStatus="idx" items="${ commentList }">
			<div ng-controller="CollapseCtrl">
				<c:if test="${ comment.articleId != articleId }">
					<h5><b>------------  ${ comment.title }  ------------</b></h5>
					<c:set var="articleId" value="${ comment.articleId }" />
				</c:if>
				<h5>${ comment.writerId } <small>${ comment.writtenDate }</small></h5>
				<pre><xmp>${ comment.contentView }</xmp></pre>

				<button class="btn btn-default btn-xs"
					ng-click="isCollapsed = !isCollapsed">수정</button>
				<a class="btn btn-default btn-xs" href="mypage/managecmt.do?cmd=remove&cid=${ comment.commentId }&aid=${ comment.articleId }&bid=${ param.bid }">삭제</a>
				<div class="comment-modify" collapse="isCollapsed">
					<form action="mypage/managecmt.do" method="post">
						<textarea name="contentView" id="inputContent"
							class="form-control" rows="2" cols="50">${ comment.contentView }</textarea>
						<input type="hidden" name="commentId"
							value="${ comment.commentId }" /> 
						<input type="hidden" name="bid" value="${ param.bid }" />
						<input type="hidden" name="cmd"	value="modify" />
						<input class="btn btn-default btn-xs" type="submit" value="댓글수정" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</div>