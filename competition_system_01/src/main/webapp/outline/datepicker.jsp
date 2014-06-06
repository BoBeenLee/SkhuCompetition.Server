<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<base href="/competition_system_01/">

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>

<!-- datepicker -->
<script type="text/javascript"
	src="js/calendar/jquery.timepicker.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/calendar/jquery.timepicker.css" />

<script type="text/javascript" src="js/calendar/bootstrap-datepicker.js"></script>
<link rel="stylesheet" type="text/css"
	href="css/calendar/bootstrap-datepicker.css" />


</head>
<body>
	<div class="datepair">
		<div>
			<input class="date" type="text" />
		</div>
	</div>
	<script>
	$('.datepair div .date').datepicker({
		'format' : 'yyyy-m-d',
		'autoclose' : true
	});

	// initialize datepairs
	$('.datepair').datepair();
</script>
</body>
</html>