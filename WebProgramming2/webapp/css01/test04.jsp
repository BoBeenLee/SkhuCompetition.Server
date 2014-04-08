<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<title>CSS Test 04</title>
<style>
    div { padding: 20px; border: solid 1px black; width: 300px; margin-top: 20px; }
    div.c1 { background-color: #ffaaaa; }
    div.c2 { background-color: #aaffaa; display: inline-block; }
    div.c3 { background-color: #dddddd; display: inline-block; }
    div.c4 { background-color: #ffffaa; display: none; 
        position: absolute; left: 200px; top: 50px; 
        box-shadow: 10px 10px 20px #666666;
    }
</style>
</head>
<body>

<div class="c1">
     내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
</div>

<div class="c2">
    내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
</div>

<div class="c3">
    내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
</div>

<button onclick="$('.c4').show()">노란색 사각형 보이기</button>

<div class="c4">
    내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
</div>

</body>
</html>