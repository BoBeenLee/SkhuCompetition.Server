<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
input[name=논문제목] { width: 100%; margin-bottom: 20px; }
input[name=학위취득일] { width: 100px; }
textarea[name=논문요약] { width: 100%; height: 400px; margin-bottom: 20px; overflow-y: scroll; }
</style>
</head>
<body>

  <div class="container">
    <%@ include file="_menu_user.jsp"%>

    <div class="mainbody">

<h1>이력서</h1>

<ul class="nav nav-tabs">
    <li><a href="resume_page1.jsp">인적사항</a></li>
    <li><a href="resume_page2.jsp">경력</a></li>
    <li class="active"><a href="resume_page3.jsp">최종학위논문</a></li>
    <li><a href="resume_page4.jsp">사진&amp;학위증</a></li>
</ul>    

<form id="이력서3">

    <h3>논문제목</h3>
    <input data-lsj-focus="True" data-lsj-validate="required" name="논문제목" type="text" value="제목" />

    <h3>논문요약</h3>
    <textarea cols="20" data-lsj-validate="required" name="논문요약" rows="2">요약</textarea>

    <div>
    <div class="td">
        <div>학위취득일</div>
        <input data-lsj-mask="9999-99-99" data-lsj-validate="required" name="학위취득일" type="text" value="2014-01-14" />
    </div>
    <div class="td">
        <div>학위취득국가명</div>
        <input data-lsj-validate="required" name="학위취득국가" type="text" value="국가명" />
    </div>
    </div>
</form>

<hr />
<a class="btn btn-info" href="resume_page3.jsp"><i class="icon-refresh icon-white"></i> 새로고침 </a>
<a class="btn btn-primary"><i class="icon-hdd icon-white"></i> 저장 </a>
    
    <%@ include file="_footer.jsp"%>
  </div>
</div>
 

</body>
</html>
