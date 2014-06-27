<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet/less" type="text/css" href="css/common/mail.less" />

<!-- autosize -->
<script src="js/common/jquery.autosize.min.js"></script>

<div class="mail">
	<form action="mail/sendMail.do" method="post">
		<div ng-controller="OpenWindowCtrl" class="mailList form-group" 
		ng-init="init([
			<c:forEach var="mail" varStatus="idx" items="${ mailList.mails }">
			{
				itemId : '${ mail.toId }',
				itemName : '${ mail.toName }'
			}
			<c:if test="${ !idx.last }">, </c:if>
			</c:forEach>
		 ])" >
		 	<div class="form-group">
				<label for="inputUserId" class="control-label">받는이 :</label>
				<button id="inputUserId" type="button" ng-click="popup('findUsers.do')"
					class="btn btn-default"><img src="image/common/search.png" /> 받는이 찾기</button>
			</div>
			<ul>
				<li ng-repeat="item in itemList"><input type="hidden"
					name="mailList" value="{{ item.itemId }}" />{{	item.itemId }}({{ item.itemName }})
				<input type="button" ng-click="removeItem($index)" class="btn" value="삭제" /></li>
			</ul>
		</div>
		<input type="text" class="form-control" name="title" />
		<div ng-controller="AutoSizeCtrl">
			<textarea id="inputContent" name="content" class="form-control"></textarea>
		</div>
		<input class="btn btn-default pull-right" type="submit"
			value="보내기" />
	</form>
</div>