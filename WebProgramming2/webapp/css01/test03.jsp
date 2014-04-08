<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CSS Test 03</title>
<style>
    div.c1 { padding: 20px; background-color: yellow; border: solid 1px black; }
    div.c1 div { padding: 20px 80px 20px 80px; background-color: #aaffaa; }

    div.c2 { margin-top: 20px; background-color: yellow; border: solid 1px black; }
    div.c2 div { margin: 20px; padding: 20px;  background-color: #ffaaaa; text-align: center; }

    div.c3 { margin-top: 20px; background-color: yellow; border: solid 1px black; width: 600px; }
    div.c3 div { margin: 20px; padding: 20px 80px 20px 80px; background-color: #dddddd; }

</style>
</head>
<body>

<div class="c1">
    <div>
        내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
    </div>        
</div>

<div class="c2">
    <div>
        내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
    </div>        
</div>

<div class="c3">
    <div>
        내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
    </div>        
</div>

</body>
</html>