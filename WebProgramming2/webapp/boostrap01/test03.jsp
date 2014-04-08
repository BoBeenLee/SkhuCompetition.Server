<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap01</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script> 
</head>
<style>
div.span2 { background-color: #aaffaa; height: 400px; }
div.span10 { background-color: #ffffaa; height: 400px; }
</style>
<body>

    <div class="container">
      <div class="row">
        <div class="span2">
            <% for (int i=0; i < 10; ++i) { %>
                왼쪽 영역 내용
            <% } %>                
        </div>
        <div class="span10">
            <% for (int i=0; i < 50; ++i) { %>
                본문 내용
            <% } %>                
        </div>
      </div>
    </div>
    
    <hr />

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
            <% for (int i=0; i < 10; ++i) { %>
                왼쪽 영역 내용
            <% } %>                
        </div>
        <div class="span10">
            <% for (int i=0; i < 50; ++i) { %>
                본문 내용
            <% } %>                
        </div>
      </div>
    </div>

</body>
</html>
