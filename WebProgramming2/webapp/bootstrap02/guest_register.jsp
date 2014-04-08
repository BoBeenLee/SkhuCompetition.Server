<%@ page contentType="text/html;charset=utf-8"%>
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
      <h1>회원가입</h1>
      <hr />

      <form id="회원가입">
        <div>아이디</div>
        <input name="로그인ID" type="text" />

        <div>비밀번호</div>
        <input name="비밀번호1" type="password" />

        <div>비밀번호 확인</div>
        <input name="비밀번호2" type="password" />

        <div>이름</div>
        <input name="이름" type="text" />

        <div>이메일</div>
        <input name="이메일" type="text" />

        <div>
          <a class="btn btn-primary"><i class="icon-user icon-white"></i> 회원가입</a>
        </div>
      </form>

      <div class="help">
        <div>
          <i class="icon-info-sign"></i> 도움말
        </div>
        <ul>
          <li>비밀번호는 암호화되어 저장됩니다.</li>
          <li>비밀번호를 분실하여 임시 비밀번호를 전송할 때 이메일 주소가 필요합니다.</li>
        </ul>
      </div>
    </div>

    <%@ include file="_footer.jsp"%>
  </div>

</body>
</html>
