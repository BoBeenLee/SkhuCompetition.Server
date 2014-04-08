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
      <h1>비밀번호 찾기</h1>
      <hr />
          
      <form id="임시비밀번호전송">
          <div>아이디</div>
          <input name="로그인ID" type="text" />
      
          <div>이메일</div>
          <input name="이메일" type="text" />
      
          <div>
              <a class="btn btn-primary"><i class="icon-envelope icon-white"></i> 임시 비밀번호 전송</a>
          </div>
      </form>
      
      <div class="help">
          <div><i class="icon-info-sign"></i> 도움말</div>
          <ul>
              <li>회원가입에서 등록한 로그인ID와 이메일 주소를 입력해주세요.</li>
              <li>이메일 주소로 새로 발급된 임시 비밀번호가 전송됩니다.</li>
          </ul>
      </div>
    </div>

    <%@ include file="_footer.jsp"%>
  </div>

</body>
</html>
