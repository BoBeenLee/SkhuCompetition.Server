<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div ng-controller="AutoSizeCtrl" class="comment">
	<c:if test="${ not empty commentView.writerId }">
		<div class="comment-header">
			<form:form action="${boardType}/article/addComment.do" method="post"
				commandName="commentView">
				<label class="control-label">이름 : ${ commentView.writerId }</label>
				<form:textarea path="content" id="inputContent"
					class="form-control" />
				<form:hidden path="writerId" />
				<form:hidden path="articleId" />
				<input type="hidden" name="bid" value="${ pagination.bid }" />
				<input type="hidden" name="sz" value="${ pagination.sz }" />
				<input type="hidden" name="pg" value="${ pagination.pg }" />
				<input class="form-control btn btn-default input-sm" type="submit"
					value="확인" />
			</form:form>
		</div>
	</c:if>
	<div class="comment-content">
		<c:forEach var="comment" varStatus="idx" items="${ commentList }">
			<div ng-controller="CollapseCtrl">
				<h5>${ comment.writerId }</h5>
				<h5>${ comment.writtenDate }</h5>

				<button class="btn btn-default btn-xs"
					ng-click="isCollapsed = !isCollapsed">수정</button>
				<a class="btn btn-default btn-xs" href="${boardType}/article/removeComment.do?${ pagination }&aid=${ commentView.articleId }&cid=${ comment.commentId }">삭제</a>

				<p>${ comment.contentView }</p>

				<div class="comment-modify" collapse="isCollapsed">
					<form action="${boardType}/article/modifyComment.do" method="post">
						<textarea name="content" id="inputContent"
							class="form-control" rows="2" cols="50">${ comment.contentView }</textarea>
						<input type="hidden" name="commentId"
							value="${ comment.commentId }" /> 
						<input type="hidden" name="bid" value="${ pagination.bid }" /> 
						<input type="hidden" name="sz" value="${ pagination.sz }" /> 
						<input type="hidden" name="pg" value="${ pagination.pg }" /> 
						<input class="form-control btn btn-default input-sm" type="submit" value="확인" /> 
						<input class="btn btn-default btn-xs" type="submit" value="수정" />
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</div>