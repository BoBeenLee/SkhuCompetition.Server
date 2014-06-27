<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet/less" type="text/css" href="css/common/board.less">
<div class="board">
	<div class="board-content">
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th>제목</th>
					<th class="text-center">글쓴이</th>
					<th class="text-center">날짜</th>
					<th class="text-center">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ pagination.currentPage <= 1 }">
					<c:forEach var="notice" items="${ noticeList }">
						<tr>
							<td class="text-center"><span class="glyphicon glyphicon-volume-down"></span></td>
							<td>
							<c:if test="${ notice.password != null }"> 
								<a href="${ boardType }/article/confirmpw.do?${ pagination }&pg=${ pagination.currentPage }&ai=${ notice.articleId }">${ notice.title }[${notice.commentCount}]</a>
							</c:if>
							<c:if test="${ notice.password == null }">
								<a href="${ boardType }/article/read.do?${ pagination }&pg=${ pagination.currentPage }&ai=${ notice.articleId }">${ notice.title }[${notice.commentCount}]</a>
							</c:if>
							</td>
							<td class="text-center">${ notice.writerId }</td>
							<td class="text-center">${ notice.writtenDate }</td>
							<td class="text-center">${ notice.hit }</td>
						</tr>
					</c:forEach>
				</c:if>
				<c:forEach var="article" varStatus="idx" items="${ boardList }">
					<c:set var="articleNum"
						value="${ (boardCount - (pagination.currentPage - 1) * pagination.pageSize)  - (idx.index) }" />
					<tr>
						<td class="text-center">${ articleNum }</td>
						<td>
						<c:if test="${ article.password != null }"> 
							<a href="${ boardType }/article/confirmpw.do?${ pagination }&pg=${ pagination.currentPage}&ai=${ article.articleId }">${ article.title }[${article.commentCount}]</a>
						</c:if>
						<c:if test="${ article.password == null }">
							<a href="${ boardType }/article/read.do?${ pagination }&pg=${ pagination.currentPage}&ai=${ article.articleId }">${ article.title }[${article.commentCount}]</a>
						</c:if>
						</td>
						<td class="text-center">${ article.writerId }</td>
						<td class="text-center">${ article.writtenDate }</td>
						<td class="text-center">${ article.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="board-menu">
		<form class="form-inline" action="${ boardType }/board.do"
			method="get" role="form">
			<input type="hidden" name="bid" value="${ pagination.boardCodeId }" />
			<input type="hidden" name="is" value="${ pagination.isShare }" />
			<div class="board-search pull-left">
				<select name="st" class="form-control input-sm">
					<option
						<c:if test="${pagination.srchType == 'title' }">selected="selected"</c:if>
						value="title">제목</option>
					<option
						<c:if test="${pagination.srchType == 'tagName' }">selected="selected"</c:if>
						value="tagName">태그</option>	
					<option
						<c:if test="${pagination.srchType == 'writerId' }">selected="selected"</c:if>
						value="writerId">글쓴이</option>
				</select> <input type="text" name="ct" class="form-control input-sm"
					value="${pagination.content}" /> <button
					class="form-control btn btn-default" type="submit">
						<img src="image/common/search.png" />
					</button>
			</div>
		</form>
		<div class="board-page-list">
			<ul class="pagination">
				<c:if test="${ pagination.currentPage - 1 > 0}">
					<li><a
						href="${ boardType }/board.do?${ pagination }&pg=${ pagination.currentPage - 1 }">«</a></li>
				</c:if>
				<c:set var="maxPageNum"
					value="${ (boardCount / pagination.pageSize) + ( 1 - (boardCount / pagination.pageSize) % 1) % 1 }" />
				<c:forEach var="pageNum" begin="1" end="${ maxPageNum }">
					<li><a
						href="${ boardType }/board.do?${ pagination }&pg=${ pageNum }">${ pageNum }</a></li>
				</c:forEach>
				<c:if
					test="${ pagination.currentPage + 1 <= boardCount / pagination.pageSize + 1 }">
					<li><a
						href="${ boardType }/board.do?${ pagination }&pg=${ pagination.currentPage + 1 }">»</a></li>
				</c:if>
			</ul>
		</div>
		<div class="board-option pull-right">
		<c:if test="${ pagination.isShare == 1 }">
			<form class="form-inline pull-right" action="${ boardType }/board.do" method="get" role="form">
			<select name="bid" class="form-control input-sm">
				 <option value="0">전체보기</option>
				 <c:forEach var="boardCode" items="${ boardCodeList }">
				 	<option value="${ boardCode.boardCodeId }" <c:if test="${ pagination.boardCodeId == boardCode.boardCodeId }">selected="selected"</c:if>>${ boardCode.boardName }</option>
				 </c:forEach>
			</select>
			<input type="hidden" name="is" value="${ pagination.isShare }" />
			<input
				class="form-control btn btn-default" type="submit" value="조회" />
			</form>
		</c:if>
		<c:if test="${ isWrite && pagination.isShare == 0 }">
			<a
				href="${ boardType }/article/write.do?${ pagination }&pg=${ pagination.currentPage}"
				class="board-write btn btn-default pull-right">글쓰기</a>
		</c:if>
		</div>	
	</div>
</div>
