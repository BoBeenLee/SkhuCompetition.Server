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
hr {  margin-top: 70px; margin-bottom: 70px; }
</style>
<body>

  <div class="container">

    <form>
      <div class="input-append">
        <input class="span2" id="appendedInputButton" type="text">
        <button class="btn" type="button">검색</button>
      </div> <br />
      
      <div class="input-append">
        <input class="span2" id="appendedDropdownButton" type="text">
        <div class="btn-group">
          <button class="btn dropdown-toggle" data-toggle="dropdown">
            작업 <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a href="#">메뉴 1</a></li>
            <li><a href="#">메뉴 2</a></li>
          </ul>
        </div>
      </div> <br />
      
      <div class="input-prepend">
        <div class="btn-group">
          <button class="btn dropdown-toggle" data-toggle="dropdown">
            작업 <span class="caret"></span>
          </button>
          <ul class="dropdown-menu">
            <li><a href="#">메뉴 1</a></li>
            <li><a href="#">메뉴 2</a></li>
          </ul>
        </div>
        <input class="span2" id="prependedDropdownButton" type="text">
      </div>      
    </form>      
    <hr />

    <form>
        <div class="controls-row">
            <input class="span2" type="text" placeholder=".span2">
            <input class="span3" type="text" placeholder=".span3">
            <input class="span4" type="text" placeholder=".span4">
        </div>
        <div class="controls-row">        
            <select class="span1">
                <option>하나</option>
                <option>둘</option>
                <option>셋</option>
            </select>
            <select class="span2">
                <option>하나</option>
                <option>둘</option>
                <option>셋</option>
            </select>
            <select class="span3">
                <option>하나</option>
                <option>둘</option>
                <option>셋</option>
            </select>
        </div>        
    </form>
    
  </div>

</body>
</html>
