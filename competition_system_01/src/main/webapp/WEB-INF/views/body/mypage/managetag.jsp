<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet/less" type="text/css" href="css/mypage/mypage.less" />

<div class="managetag">
	<div>
		<h5>태그 키워드</h5>
		<c:forEach var="tag" items="${ tagTypeList }">
			<a href="mypage/managetag.do?tn=${ tag.tagName }" class="btn btn-default btn-sm">${ tag.tagName }</a>
		</c:forEach>
	</div>
	<hr>
	<div>
		<table class="table table-condensed table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>파일이름</th>
					<th>제출자</th>
					<th>편집</th>
				</tr>	
			</thead>
			<tbody>
				<c:forEach var="tag" varStatus="idx" items="${ tagList }">
					<tr>
						<td>${ idx.count }</td>
						<td><a href="${ tag.fileUrl }">${ tag.fileName }</a></td>
						<td>${ tag.userId }</td>
						<td>
							<form action="mypage/modifytag.do" method="get">
								<span><input class="form-control" name="tagName" type="text" value="${ tag.tagName }" /></span>
								<span>
									<input type="hidden" name="tn" value="${ param.tn }" />
									<input type="hidden" name="tagId" value="${ tag.tagId }" />
									<input class="btn btn-default" type="submit" value="수정" />	
								</span>
								<span>
									<a href="mypage/removetag.do?tid=${ tag.tagId }&tn=${ param.tn }" class="btn btn-default">삭제</a>
								</span>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>