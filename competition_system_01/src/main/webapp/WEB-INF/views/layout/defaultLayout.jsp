<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="competition">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">

<link rel="stylesheet/less" type="text/css" href="css/main/main.less">
<link rel="stylesheet/less" type="text/css"
	href="css/common/common.less">

<!-- sub1 -->
<link rel="stylesheet/less" type="text/css" href="css/user/login.less">
<link rel="stylesheet/less" type="text/css" href="css/common/sub1.less">
<link rel="stylesheet/less" type="text/css" href="css/common/sub.less">

<!-- board -->
<link rel="stylesheet/less" type="text/css" href="css/common/board.less">
<link rel="stylesheet/less" type="text/css"
	href="css/common/article.less">
<link rel="stylesheet/less" type="text/css"
	href="css/common/comment.less">

<!-- editor -->
<script src="css/ckeditor/ckeditor.js"></script>

<!-- fullcalendar -->
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css"
	rel='stylesheet' />
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css"
	rel='stylesheet' media='print' />

<!-- angularjs -->
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script src="//code.jquery.com/jquery.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>

<!-- autosize -->
<script src="js/common/jquery.autosize.min.js"></script>


<script type="text/javascript">
	var myAppModule = angular.module('competition', [ 'ui.bootstrap' ]);
	
	myAppModule.controller('CollapseCtrl', [ '$scope', function($scope) {
		$scope.isCollapsed = true;
	} ]);

	myAppModule.controller('OpenWindowCtrl', [ '$scope', '$window', function($scope, $window) {
		$scope.itemList = [];
		$window.$windowScope = $scope;
		$scope.popup = function(url){
			$window.open("popup/" + url, '_blank', 'width=400, height=400, toolbar=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no');	
		};
		
		$scope.addItem = function(item){
			$scope.itemList.push(item);
			$scope.$apply();
		};
	} ]);

	myAppModule.controller('AutoSizeCtrl', [ '$scope', function($scope) {
		$('textarea').autosize();
	} ]);
	
	myAppModule.controller('CalendarCtrl', [ '$scope', function($scope) {
		var calendarList = [  
		    <c:forEach var="calendar" varStatus="idx" items="${ calendarList }">
		    {
		        title : '${ calendar.content }',
		        start : new Date('${ calendar.startDateView }'),
		        end : new Date('${ calendar.endDateView }'),
		        allDay : false
		    } 
		    <c:if test="${ !idx.last }">, </c:if>
		    </c:forEach>  
		];
		           		
		$('#calendar').fullCalendar({
		    editable : false,
		    events : calendarList
		});
	} ]);
	
	myAppModule.controller('ManageScCtrl', [ '$scope', function($scope) {
		$scope.getSelectedBid = function(url){
			var param = { bid : $scope.bid };
			//alert(url);
			// fire off the request to AjaxCtrl 
			$.ajax({
			      url: url,
			      method: "get",
			      type: "json",
			      data : param,
			      success: function(data) {
			    	$scope.teamList = data;
			    	$scope.$apply();
			      },
			      error : function(data, status){
			    	 alert(data + " error");
			      }
			 });
		};
	} ]);

	


</script>

</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>