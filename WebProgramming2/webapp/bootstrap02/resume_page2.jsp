<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
#이력서학력대화상자 form div { margin-bottom: 10px;  }
#이력서학력대화상자 div.inline:nth-child(1) { width: 50px; }
#이력서학력대화상자 select { width: 100px; }
#이력서학력대화상자 input[name^=기간] { width: 60px; }
#이력서학력대화상자 input[name=국가] { width: 100px; }
#이력서학력대화상자 input[name=학교명] { width: 400px; }
</style>
</head>
<body>

  <div class="container">
    <%@ include file="_menu_user.jsp"%>

    <div class="mainbody">
    
<h1>이력서</h1>

<ul class="nav nav-tabs">
    <li><a href="resume_page1.jsp">인적사항</a></li>
    <li class="active"><a href="resume_page2.jsp">경력</a></li>
    <li><a href="resume_page3.jsp">최종학위논문</a></li>
    <li><a href="resume_page4.jsp">사진&amp;학위증</a></li>
</ul>    
 
<div class="학력">
    <div class="controls pull-right">
        <a class="btn btn-small btn-info" onclick="학력대화상자()">학력 추가</a>
    </div>

    <h3>학력</h3>
    <div id="이력서학력출력">
    <table class="table table-bordered 학력">
    <thead>
        <tr>
            <td>구분</td>
            <td>기간</td>
            <td>국가</td>
            <td>학교명</td>
            <td>학과(전공)</td>
            <td>세부전공분야</td>
        </tr>
    </thead>
    <tbody>
            <tr  class="hover">
                <td></td>
                <td> ~ </td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
    </tbody>
    </table>

    </div>
</div>

<div class="교육경력">
    <div class="controls pull-right">
        <a class="btn btn-small btn-info" onclick="학력대화상자()">경력 추가</a>
    </div>

    <h3>교육 경력</h3>
    <div id="이력서교육경력출력">
    <table class="table table-bordered 경력">
    <thead>
        <tr>
            <td>기간</td>
            <td>학교명</td>
            <td>직위</td>
            <td>담당강의명</td>
        </tr>
    </thead>
    <tbody>
            <tr  class="hover">
                <td> ~ </td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
    </tbody>
    </table>

    </div>
</div>

<div class="교육외경력">
    <div class="pull-right">
        <a class="btn btn-small btn-info" onclick="학력대화상자()">경력 추가</a>
    </div>

    <h3>교육외 경력</h3>
    <div id="이력서교육외경력출력">
    <table class="table table-bordered 경력">
    <thead>
        <tr>
            <td>기간</td>
            <td>기관명</td>
            <td>직위</td>
            <td>담당직무</td>
        </tr>
    </thead>
    <tbody>
            <tr  class="hover">
                <td> ~ </td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
    </tbody>
    </table>

    </div>
</div>

<div class="논문">
    <div class="controls pull-right">
        <a class="btn btn-small btn-info" onclick="학력대화상자()">실적 추가</a>
    </div>

    <h3>연구 실적</h3>
    <div id="이력서논문출력">
    <table class="table table-bordered 논문">
    <thead>
        <tr>
            <td>논문구분</td>
            <td>논문게재지명</td>
            <td>논문제목</td>
        </tr>
    </thead>
    <tbody>
            <tr  class="hover">
                <td></td>
                <td></td>
                <td></td>
            </tr>
    </tbody>
    </table>

    </div>
</div>

<hr />
<a class="btn btn-primary" href="resume_page2.jsp"><i class="icon-refresh icon-white"></i> 새로고침 </a>

    <%@ include file="_footer.jsp"%>
  </div>
</div>

<div id="이력서학력대화상자" class="modal hide" tabIndex="-1">
    <div class="modal-header">
        <a class="close" data-dismiss="modal">×</a>
        <h1>이력서 - 학력</h1>
    </div>

    <form id="이력서학력">
        <input id="ID" name="ID" value="0" type="hidden">
        <input name="사용자ID" value="1846" type="hidden">
        <div class="modal-body">
            <div class="form-horizontal">
                <div class="inline">구분:</div>
                <select name="구분"><option>학사</option>
                   <option>석사</option>
                   <option>박사수료</option>
                   <option>박사</option>
                </select>
            </div>
            <div class="form-horizontal">
                <div class="inline">기간:</div>
                <input name="기간1" value="" type="text"> ~ <input name="기간2" value="" type="text">
            </div>
            <div class="form-horizontal">
                <div class="inline">국가:</div>
                <input name="국가" value="" type="text">
            </div>
            <div class="form-horizontal">
                <div class="inline">학교명:</div>
                <input name="학교명" value="" type="text">
            </div>
            <div class="form-horizontal">
                <div class="inline">학과:</div>
                <input name="학과" value="" type="text">
            </div>
            <div class="form-horizontal">
                <div class="inline">전공:</div>
                <input name="전공" value="" type="text">
            </div>
        </div>
    </form>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal">취소</button>
        <button class="btn btn-info" data-dismiss="modal">삭제</button>
        <button class="btn btn-primary" data-dismiss="modal">저장</button>
    </div>
</div>

<script type="text/javascript">
function 학력대화상자() {
    $("#이력서학력대화상자").modal('show');
}
</script>
  

</body>
</html>
