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
    <form>
      <fieldset>
        <legend>양식의 제목</legend>
        <label>항목명</label> 
        <input type="text" placeholder="아무거나 입력하시오…"> 
        <span class="help-block">한줄을 다 차지하는 도움말 문자열 임니다.</span> 
        <label class="checkbox"> 
            <input type="checkbox"> 체크하시오
        </label>
        <button type="submit" class="btn btn-primary">
            <i class="icon-hdd icon-white"></i>
            확인
        </button>
        <a class="btn">취소</a>
      </fieldset>
    </form>
    <hr />
    <form>
      <input type="text" class="input-medium search-query">
      <button type="submit" class="btn">검색</button>
    </form>
    <hr />
    <form class="form-inline">
      <input type="text" class="input-small" placeholder="이메일"> 
      <input type="password" class="input-small" placeholder="비밀번호"> 
      <label class="checkbox"> 
        <input type="checkbox"> 자동 로그인
      </label>
      <button type="submit" class="btn">로그인</button>
    </form>
  </div>
</body>
</html>
