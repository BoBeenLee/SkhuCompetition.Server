<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="popup">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">

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
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	var myAppModule = angular.module('popup', [ 'ui.bootstrap' ]);

	
	myAppModule.controller('ReturnCtrl', [ '$scope', '$window', function($scope, $window) {
		$scope.$parentScope = $window.opener.$windowScope;
		
		$scope.setParent = function(itemId, itemName){
			var item = {"itemId" : itemId, "itemName" : itemName};
			
			$scope.$parentScope.addItem(item);
			$scope.$apply();	
		};		
	} ]);
</script>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="body" />
	</div>
</body>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>
</html>