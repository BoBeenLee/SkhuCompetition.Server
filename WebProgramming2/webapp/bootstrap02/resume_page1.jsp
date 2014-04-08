<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
div.box { margin-bottom: 20px; }
div.td div:first-child { font-size: 9pt; color: #666; }
div.td:last-child { vertical-align: middle; }
div.td:last-child a { margin-top: 10px; }
input { margin-bottom: 0px; }
input[name=이름] { width: 150px; }
input[name=주민등록번호] { width: 120px; }
input[name=외국인등록번호] { width: 120px; }
input[name=생년월일] { width: 90px; }
input[name=이메일] { width: 150px; }
input[name=휴대전화] { width: 120px; }
input[name$=전화] { width: 100px; }
input[name$=우편번호] { width: 60px; }
input[name$=주소1] { width: 250px; }
input[name$=주소2] { width: 300px; }
input[name=직장명] { width: 200px; }
input[name=직장부서] { width: 150px; }
input[name=직장직위] { width: 150px; }
input[name^=자격증] { width: 270px; }
div.message { margin-left: 200px; font-size: 9pt; color: #888; }
div#우편번호대화상자 { width: 500px; }
div#우편번호대화상자 input[type=text] { width: 150px; }
div#우편번호대화상자_검색결과_박스 { width: 450px; height: 320px; border: 1px solid #888; margin-top: 10px; padding: 5px; overflow: auto; }
</style>
</head>
<body>

  <div class="container">
    <%@ include file="_menu_user.jsp"%>

    <div class="mainbody">
    
<h1>이력서</h1>

<ul class="nav nav-tabs">
    <li class="active"><a href="resume_page1.jsp">인적사항</a></li>
    <li><a href="resume_page2.jsp">경력</a></li>
    <li><a href="resume_page3.jsp">최종학위논문</a></li>
    <li><a href="resume_page4.jsp">사진&amp;학위증</a></li>
</ul>    

<h3>기본사항</h3>

<form id="이력서1">

<div class="box">
    <div>
        <div class="td">
            <div>이름</div>
            <input name="이름" type="text" value="이승진" />
        </div>
        <div class="td">
            <div>주민등록번호</div>
            <input name="주민등록번호" type="text" value="" />
        </div>
        <div class="td">
            <div>외국인등록번호</div>
            <input name="외국인등록번호" type="text" value="" />
        </div>
        <div class="td">
            <div>생년월일</div>
            <input name="생년월일" type="text" value="" />
        </div>
        <div class="td">
            <div>성별</div>
            <div class="radio-group">
                <input name="성별" type="radio" value="남" />남 &nbsp;
                <input name="성별" type="radio" value="여" />여 &nbsp;
            </div>
        </div>
    </div>

    <div>
        <div class="td">
            <div>이메일</div>
            <input name="이메일" type="text" value="lsj@skhu.ac.kr" />
        </div>
        <div class="td">
            <div>휴대전화</div>
            <input name="휴대전화" type="text" value="" />
        </div>
        <div class="td">
            <div>강사전업여부</div>
            <div class="radio-group">
                <input name="강사전업여부" type="radio" value="전업" />전업 &nbsp;
                <input name="강사전업여부" type="radio" value="직장보유" />직장보유 &nbsp;
                <input name="강사전업여부" type="radio" value="겸직가능" />겸직가능 &nbsp;
            </div>
        </div>
    </div>
</div>

<h3>자택</h3>
<div class="box">

    <div>
        <div class="td">
            <div>전화번호</div>
            <input name="집전화" type="text" value="" />
        </div>
        <div class="td">
            <div>우편번호</div>
            <div class="form-horizontal">
                <input name="집우편번호" type="text" value="" />
                <a class="btn btn-small" onclick="우편번호검색(this)">검색</a>
            </div>
        </div>
        <div class="td">
            <div>주소1</div>
            <input name="집주소1" type="text" value="" />
        </div>
        <div class="td">
            <div>주소2</div>
            <input name="집주소2" type="text" value="" />
        </div>
        <div class="message">(도로명 주소를 입력해주세요)</div>
    </div>
</div>

<h3>직장</h3>
<div class="box">

    <div>
        <div class="td">
            <div>직장명</div>
            <input name="직장명" type="text" value="" />
        </div>
        <div class="td">
            <div>부서</div>
            <input name="직장부서" type="text" value="" />
        </div>
        <div class="td">
            <div>직위</div>
            <input name="직장직위" type="text" value="" />
        </div>
    </div>

    <div>
        <div class="td">
            <div>전화번호</div>
            <input name="직장전화" type="text" value="" />
        </div>
        <div class="td">
            <div>우편번호</div>
            <div class="form-horizontal">
                <input name="직장우편번호" type="text" value="" />
                <a class="btn btn-small" onclick="우편번호검색(this)">검색</a>
            </div>
        </div>
        <div class="td">
            <div>주소1</div>
            <input name="직장주소1" type="text" value="" />
        </div>
        <div class="td">
            <div>주소2</div>
            <input name="직장주소2" type="text" value="" />
        </div>
        <div class="message">(도로명 주소를 입력해주세요)</div>
    </div>

</div>

<div>
    <div class="td">
        <h2>자격증</h2>
        <input name="자격증1" type="text" value="" /> 
        <input name="자격증2" type="text" value="" /> 
        <input name="자격증3" type="text" value="" />
    </div>
</div>

</form>

<hr />
<a class="btn btn-info" href="resume_page1.jsp"><i class="icon-refresh icon-white"></i> 새로고침 </a>
<a class="btn btn-primary"><i class="icon-hdd icon-white"></i> 저장 </a>


<div id="우편번호대화상자" class="modal hide" tabindex="-1" >
    <div class="modal-header">
        <a class="close" data-dismiss="modal">&times;</a>
        <h1>우편번호 검색 <small>(도로명주소)</small></h1>
    </div>

    <div class="modal-body">
        <div class="form-horizontal">
            <span>검색어:</span>
            <input id="우편번호대화상자_검색패턴" type="text" />
            <button class="btn">검색</button>
        </div>
        <div id="우편번호대화상자_검색결과_박스">
            <div id="우편번호대화상자_검색결과">
            </div>
        </div>            
    </div>

    <div class="modal-footer">
        <a class="btn" data-dismiss="modal">취소</a>
        <a class="btn btn-primary" data-dismiss="modal">확인</a>
  </div>
</div>

    <%@ include file="_footer.jsp"%>
  </div>
</div>  

<script type="text/ecmascript">
    function 우편번호검색(btn) {
        $("#우편번호대화상자").modal('show');
    }
</script>

</body>
</html>
