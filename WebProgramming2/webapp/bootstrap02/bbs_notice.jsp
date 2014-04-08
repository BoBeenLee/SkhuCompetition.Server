<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
table.table { margin-top: 4px; }
th:nth-child(1) { width: 30px; }
th:nth-child(3) { width: 80px; }
th:nth-child(4) { width: 80px; }
thead { background-color: #eee; }
tbody td span { color: #aaa; }
select[name$=srchType] { margin-left: 40px; width: 100px; }
div.form-inline input[type=text] { width: 120px; }
select[name$=size] { width: 60px; }
</style>
</head>
<body>

  <div class="container">
    <%@ include file="_menu_user.jsp"%>

    <div class="mainbody">
      <h1>공지사항</h1>
      <hr />

      <div class="controls pull-right">
        <a href="/Bbs/New/1" class="btn btn-small btn-primary">글쓰기</a>
      </div>
      <div class="form-inline">
        <span>분류:</span>
        <select name="pagination.category">
            <option selected="selected" value="0">전체</option>
            <option value="12">미분류</option>
        </select> 
        <select name="pagination.srchType">
            <option selected="selected" value="0">검색없음</option>
            <option value="1">제목</option>
            <option value="2">제목+내용</option>
            <option value="3">작성자</option>
        </select> 
        <input name="pagination.srchText" type="text" value="" />
        <a class="btn btn-small">검색</a>
      </div>

      <table class="table table-condensed table-bordered">
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr onclick="location.href='bbs_article.jsp'">
            <td>1</td>
            <td><span>[미분류]</span> 테스트 공지</td>
            <td>admin</td>
            <td>2013-12-12</td>
          </tr>
          <tr onclick="location.href='bbs_article.jsp'">
            <td>2</td>
            <td><span>[미분류]</span> 테스트 공지</td>
            <td>admin</td>
            <td>2013-12-12</td>
          </tr>
          <tr onclick="location.href='bbs_article.jsp'">
            <td>3</td>
            <td><span>[미분류]</span> 테스트 공지</td>
            <td>admin</td>
            <td>2013-12-12</td>
          </tr>
        </tbody>
      </table>

      <div class="controls pull-right form-inline">
        화면크기: 
        <select name="pagination.size">
            <option>10</option>
          <option selected="selected">15</option>
          <option>20</option>
          <option>30</option>
          <option>50</option>
          <option>100</option>
        </select>
      </div>

      <div class="pagination pagination-small pagination-centered">
        <ul>
          <li><a><b style="color: black;">1</b></a></li>
          <li><a>2</a></li>
          <li><a>3</a></li>
          <li><a>4</a></li>
          <li><a>5</a></li>
        </ul>
      </div>
    </div>

    <%@ include file="_footer.jsp"%>
  </div>

</body>
</html>
