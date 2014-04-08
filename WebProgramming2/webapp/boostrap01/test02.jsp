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
<style>
  div.row { margin-top: 5px; }
  div.row div { background-color: #ccc; text-align: center; line-height: 40px; }
</style>
</head>
<body>

<div class="container">
  <div class="row">
    <div class="span1">span1</div>  <div class="span1">span1</div>  <div class="span1">span1</div>
    <div class="span1">span1</div>  <div class="span1">span1</div>  <div class="span1">span1</div>
    <div class="span1">span1</div>  <div class="span1">span1</div>  <div class="span1">span1</div>
    <div class="span1">span1</div>  <div class="span1">span1</div>  <div class="span1">span1</div>
  </div>
  <div class="row">
    <div class="span2">span2</div>  <div class="span2">span2</div>  <div class="span2">span2</div>
    <div class="span2">span2</div>  <div class="span2">span2</div>  <div class="span2">span2</div>
  </div>
  <div class="row">
    <div class="span4">span4</div>  <div class="span3">span3</div>  <div class="span5">span5</div>
  </div>
  <div class="row">
    <div class="span4">span4</div>
    <div class="span3 offset5">span3 offset2</div>
  </div>
  <div class="row">
    <div class="span4 offset1">span4 offset1</div>
    <div class="span5 offset2">span5 offset2</div>
  </div>
  <div class="row">
    <div class="span9 offset3">span9 offset3</div>
  </div>
</div>

</body>
</html>
