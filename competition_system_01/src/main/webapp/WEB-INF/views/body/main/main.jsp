<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(document).ready(function() {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();

		$('#calendar').fullCalendar({
			editable : false,
			events : [ {
				title : 'All Day Event',
				start : new Date(y, m, 1)
			}, {
				title : 'Long Event',
				start : new Date(y, m, d - 5),
				end : new Date(y, m, d - 2)
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d - 3, 16, 0),
				allDay : false
			}, {
				id : 999,
				title : 'Repeating Event',
				start : new Date(y, m, d + 4, 16, 0),
				allDay : false
			}, {
				title : 'Meeting',
				start : new Date(y, m, d, 10, 30),
				allDay : false
			}, {
				title : 'Lunch',
				start : new Date(y, m, d, 12, 0),
				end : new Date(y, m, d, 14, 0),
				allDay : false
			}, {
				title : 'Birthday Party',
				start : new Date(y, m, d + 1, 19, 0),
				end : new Date(y, m, d + 1, 22, 30),
				allDay : false
			}, {
				title : 'Click for Google',
				start : new Date(y, m, 28),
				end : new Date(y, m, 29),
				url : 'http://google.com/'
			} ]
		});
	});
</script>


<div class="content row">
	<div class="col-md-4">
		<div class="box box-board col-md-12 row">
			<h4>공지사항</h4>
			<ul>
				<li><a href="#"> Notice 1 </a></li>
				<li><a href="#"> Notice 2 </a></li>
				<li><a href="#"> Notice 3 </a></li>
				<li><a href="#"> Notice 4 </a></li>
			</ul>
		</div>
		<div class="box box-board col-md-12 row">
			<h4>경진대회</h4>
			<ul>
				<li><a href="#"> Competition 1 </a></li>
				<li><a href="#"> Competition 2 </a></li>
				<li><a href="#"> Competition 3 </a></li>
				<li><a href="#"> Competition 4 </a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-8">
		<div class="box box-calendar">
			<div id="calendar"></div>
		</div>
	</div>
</div>