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
hr {  margin-top: 70px; margin-bottom: 70px; }
</style>
</head>
<body>

  <div class="container">

    <form class="form-horizontal">
      <div class="control-group">
        <label class="control-label" for="inputEmail">이메일</label>
        <div class="controls">
          <input type="text" id="inputEmail" placeholder="이메일">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="inputPassword">비밀번호</label>
        <div class="controls">
          <input type="password" id="inputPassword" placeholder="비밀번호">
        </div>
      </div>
      <div class="control-group">
        <div class="controls">
          <label class="checkbox"> <input type="checkbox"> 자동 로그인</label>
          <button type="submit" class="btn">로그인</button>
        </div>
      </div>
    </form>
    <hr />

    <form>
      <div class="input-prepend">
        <span class="add-on">@</span> 
        <input class="span2" id="prependedInput" type="text" placeholder="사용자명">
      </div> <br />
      <div class="input-append">
        <input class="span2" id="appendedInput" type="text" placeholder="무게"> 
        <span class="add-on">kg</span>
      </div> <br />
      <div class="input-prepend input-append">
        <span class="add-on">합계</span> 
        <input class="span2" id="appendedPrependedInput" type="text"> 
        <span class="add-on">원</span>
      </div> <br />
      <div class="input-append">
        <input class="span4" id="appendedInputButton" type="text">
        <button class="btn" type="button">검색</button>
      </div>
    </form>
  </div>

</body>
</html>
