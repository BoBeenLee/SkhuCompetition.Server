<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- autosize -->
<script src="js/common/jquery.autosize.min.js"></script>

<link rel="stylesheet/less" type="text/css"
	href="css/common/comment.less">

<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin" />
<sec:authentication property="name" var="currentUserName"/>

<div ng-controller="AutoSizeCtrl" class="comment">
	<sec:authorize access="!isAnonymous()">
		<div class="comment-header">
			<form:form action="${boardType}/article/addComment.do" method="post"
				commandName="commentView">
				<label class="control-label">이름 : ${ commentView.writerId }</label>
				<form:textarea path="contentView" id="inputContent"
					class="form-control" />
				<form:hidden path="writerId" />
				<form:hidden path="articleId" />
				<input type="hidden" name="bid" value="${ pagination.bid }" />
				<input type="hidden" name="sz" value="${ pagination.sz }" />
				<input type="hidden" name="pg" value="${ pagination.pg }" />
				<input class="btn btn-default pull-right" type="submit"
					value="댓글쓰기" />
			</form:form>
		</div>
	</sec:authorize>
	<div class="comment-content">
		<c:forEach var="comment" varStatus="idx" items="${ commentList }">
			<div ng-controller="CollapseCtrl">
				<h5>${ comment.writerId }<small>${ comment.writtenDate }</small></h5>
				<pre><xmp>${ comment.contentView }</xmp></pre>
				<c:if test="${ comment.writerId == currentUserName || isAdmin }">
				<button class="btn btn-default btn-xs"
					ng-click="isCollapsed = !isCollapsed">수정</button>
				<a class="btn btn-default btn-xs" href="${boardType}/article/removeComment.do?${ pagination }&aid=${ commentView.articleId }&cid=${ comment.commentId }">삭제</a>
				<div class="comment-modify" collapse="isCollapsed">
					<form action="${boardType}/article/modifyComment.do" method="post">
						<textarea name="contentView" id="inputContent"
							class="form-control" rows="2" cols="50">${ comment.contentView }</textarea>
						<input type="hidden" name="commentId"
							value="${ comment.commentId }" /> 
						<input type="hidden" name="bid" value="${ pagination.bid }" /> 
						<input type="hidden" name="sz" value="${ pagination.sz }" /> 
						<input type="hidden" name="pg" value="${ pagination.pg }" /> 
						<input class="btn btn-default btn-xs" type="submit" value="댓글수정" />
					</form>
				</div>
				</c:if>
			</div>
		</c:forEach>
	</div>
</div>