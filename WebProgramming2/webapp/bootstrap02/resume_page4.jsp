<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
div.controls { margin-top: 10px; margin-bottom: 50px; }
div#빈사진 { border: 1px solid #ddd; background-color: #eee; padding-top: 0px; text-align: center; width: 160px; height: 160px; color: #888; line-height: 80px; }
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
    <li><a href="resume_page3.jsp">최종학위논문</a></li>
    <li class="active"><a href="resume_page4.jsp">사진&amp;학위증</a></li>
</ul>  

<h3>사진</h3>
    <div id="빈사진">
        증명사진
    </div>

<div class="controls">
    <a class="btn btn-info" onclick="파일첨부대화상자_보이기()"><i class="icon-upload icon-white"></i> 사진 올리기</a>
</div>

<h3>최종학위증명서 파일</h3>

    <div class="box">
        <span>파일명</span> 
        <span>(0 Kbytes)</span>
    </div>

<div class="controls">
    <a class="btn btn-info" onclick="파일첨부대화상자_보이기()"><i class="icon-upload icon-white"></i> 파일 올리기</a>
</div>

    <%@ include file="_footer.jsp"%>
  </div>
</div>


<div id="파일첨부대화상자" class="modal hide" tabindex="-1" role="dialog" >
    <div class="modal-header">
        <a class="close" data-dismiss="modal">&times;</a>
        <h1 id="파일첨부대화상자_제목">파일 첨부</h1>
    </div>

    <div class="modal-body">
        <div id="waitimage" >
            <img src="res/img/wait-small.gif" alt="loading..." />
        </div>
        <iframe width="450" height="120" frameBorder="0">
        </iframe>
    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">취소</button>
        <button class="btn btn-primary">업로드</button>
  </div>
</div>

<script type="text/javascript">
function 파일첨부대화상자_보이기() {
    $("#파일첨부대화상자").modal('show');
}
</script>  

</body>
</html>
