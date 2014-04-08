<%@ page contentType="text/html;charset=utf-8" %> 
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
    form div { margin-top: 20px; }
</style>
</head>
<body>

  <div class="container">
    <%@ include file="_menu_guest.jsp"%>

    <div class="mainbody">
      <h1>로그인</h1>
      <hr />

      <form id="로그인">
        <div>아이디</div>
        <input name="로그인ID" type="text" />

        <div>비밀번호</div>
        <input name="비밀번호" type="password" />

        <div>
          <a class="btn btn-primary"><i class="icon-ok icon-white"></i> 로그인</a> 
          <a class="btn" href="guest_password.jsp"><i class="icon-search"></i> 비밀번호 찾기</a> 
          <a class="btn" href="guest_register.jsp"><i class="icon-user"></i> 회원가입</a>
        </div>
      </form>
    </div>

    <%@ include file="_footer.jsp"%>
  </div>

</body>
</html>
