<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CSS Test 01</title>
<style>
    h1 { color : blue; font-size: 12px; }
    #para1 { text-align: center; color: red; }
    .center { text-align: center; }
    p#para2 { color: blue; }
    p.right { text-align: right; }
</style>
</head>
<body>

<h1>파란색 12px 크기 제목.</h1>

<div id="para1">
빨간색 가운데 정렬. 빨간색 가운데 정렬. 빨간색 가운데 정렬. <br />
빨간색 가운데 정렬. 빨간색 가운데 정렬. <br />
</div>

<h1 class="center">가운데 정렬, 파란색 12px 크기 제목.</h1>

<p id="para2"> 파란색 문단.  파란색 문단.  파란색 문단.</p>
<p> 보통 문단.  보통 문단.  보통 문단.</p>
<p class="right"> 오른쪽 정렬 문단.  오른쪽 정렬 문단.  오른쪽 정렬 문단.</p>

<p id="para2"> 파란색 문단.  파란색 문단.  파란색 문단.</p>
<p> 보통 문단.  보통 문단.  보통 문단.</p>
<p class="right"> 오른쪽 정렬 문단.  오른쪽 정렬 문단.  오른쪽 정렬 문단.</p>

</body>
</html>