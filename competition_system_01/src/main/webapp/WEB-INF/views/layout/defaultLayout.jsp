<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="competition">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="title" /></title>
<!--  경로 디폴트 설정  -->
<base href="/competition_system_01/">

<link rel="stylesheet/less" type="text/css"
	href="css/common/common.less">
	
<!-- angularjs -->
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.10/angular.js"></script>
<script
	src="//angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script src="//code.jquery.com/jquery.js"></script>

<!-- bootstrap -->
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>

<script type="text/javascript">
	var myAppModule = angular.module('competition', [ 'ui.bootstrap' ]);
	
	myAppModule.controller('CollapseCtrl', [ '$scope', function($scope) {
		$scope.isCollapsed = true;
	} ]);
	
	myAppModule.controller('OpenWindowCtrl', [ '$scope', '$window', function($scope, $window) {
		$window.$windowScope = $scope;		
		$scope.itemList = [];
		$scope.keys = [];
		
		$scope.init = function(list){
			for(var i=0; i<list.length; i++){
				$scope.addItem(list[i]);
			}
		};

		$scope.popup = function(url){			
			$window.open("popup/" + url, '_blank', 'width=430, height=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no');	
		};
		
		$scope.addItem = function(item){
			var itemObj = {itemId : item.itemId, itemName : item.itemName};
			
			if($scope.keys.indexOf(itemObj.itemId) === -1) {
				$scope.keys.push(itemObj.itemId);
				$scope.itemList.push(itemObj);
				$scope.$apply();			
			}
		};		
	    $scope.removeItem = function(index) {
	    	$scope.keys.splice($scope.keys.indexOf($scope.itemList[index].itemId), 1);
	    	$scope.itemList.splice(index, 1);
	    	$scope.$apply();
	    };	
	} ]);

	myAppModule.controller('AutoSizeCtrl', [ '$scope', function($scope) {
		$('textarea').autosize();
	} ]);
	
	myAppModule.controller('CalendarCtrl', [ '$scope', function($scope) {
		$scope.init = function(list){
			/* for(var idx in list){
				list[idx].start = new Date(list[idx].start);
				list[idx].end = new Date(list[idx].end);
			} */
			$('#calendar').fullCalendar({
			    editable : false,
			    events : list
			});
		};
	} ]);
	
	myAppModule.controller('BidToTidCtrl', [ '$scope', function($scope) {
		$scope.teamList = [];	

		$scope.init = function(bid, tid, url){
			if(bid){
				$scope.bid = bid;
				$scope.getSelectedBid(url);
			}
			if(tid){
				$scope.tid = tid;
			}
			$scope.$apply();
		};
		
		$scope.getSelectedBid = function(url){
			var param = { bid : $scope.bid };
			
			//alert($scope.bid );
			// fire off the request to AjaxCtrl 
			$.ajax({
			      url: url,
			      method: "get",
			      type: "json",
			      data : param,
			      success: function(data) {	
			    	for(var idx in data){
			    		$scope.teamList = data;
			    	}			    	
			    	$scope.$apply();
			      },
			      error : function(data, status){
			    	 alert(data + " error");
			      }
			 });
		};
	} ]);
	
	myAppModule.controller('ShowHideCtrl', [ '$scope', function($scope) {
		$scope.init = function(item){
			$scope.tmp = item;
		};
		
		$scope.change = function(){
			if($scope.confirmed)
				$scope.item = $scope.tmp;
			else 
				$scope.item = "";
		};
	} ]);
	
	myAppModule.controller('DatepickerCtrl', [ '$scope', function($scope) {
		$scope.init = function(){
			$('.datepair .datepair-date').datepicker({
				'format' : 'yyyy-m-d',
				'autoclose' : true
			});
			
			// initialize timepairs
			$('.timepair').timepicker();
			
			// fileLimitDate
			$scope.limitDate = 	$('.datepair .limitdate').val();
			
			// Event Handler
			$('.datepair .limitdate').on("change", function(){
				$scope.limitDate = $(this).val();
				$scope.$apply();
			});

			$('.limittime').on("change", function(){
				$scope.limitTime = $(this).val();
				$scope.$apply();
			});
			
		};
	} ]);
	

	myAppModule.controller('TagCtrl', [ '$scope', function($scope) {
		$scope.tagList = [];

		$scope.init = function(){	};
		$scope.addTag = function(){
			var tagName = $scope.tag;
			if($scope.tagList.indexOf(tagName) === -1)
				$scope.tagList.push(tagName);			
		};
		
	    $scope.removeTag = function(index) {
	    	$scope.tagList.splice(index, 1);
	    };			
	} ]);
	
</script>

<!-- lessjs -->
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>
</html>