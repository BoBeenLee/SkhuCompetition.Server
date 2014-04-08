<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<title>CSS Test 05</title>
<style>
    table { border-collapse:collapse; }
    td { border:1px solid black; padding: 10px; }
    tr:first-child { background-color: #888888; color: white; }
    tr:first-child td { text-align: center; font-weight: bold; }
    
    td:nth-child(1) { width: 200px; }
    td:nth-child(2) { width: 100px; text-align: right; }
           
    table.t2 { margin-top: 50px; }    
    table.t1 tr:hover { background-color: #ffffaa; cursor: pointer; }
    table.t2 tr:hover:not(:first-child) { background-color: #ffffaa; cursor: pointer; }
    table.t2 tr:nth-child(even) { background-color: #eeeeee; }
</style>
</head>
<body>

<table class="t1">
    <tr><td>이름</td><td>점수</td></tr>
    <tr><td>홍길동</td><td>100</td></tr>
    <tr><td>이순신</td><td>98</td></tr>
    <tr><td>전우치</td><td>95</td></tr>
</table>

<table class="t2">
    <tr><td>이름</td><td>점수</td></tr>
    <tr><td>홍길동</td><td>100</td></tr>
    <tr><td>이순신</td><td>98</td></tr>
    <tr><td>전우치</td><td>95</td></tr>
    <tr><td>강감찬</td><td>100</td></tr>
    <tr><td>을지문덕</td><td>93</td></tr>
    <tr><td>권율</td><td>90</td></tr>
</table>

</body>
</html>
