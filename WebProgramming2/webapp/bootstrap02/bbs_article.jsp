<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_header.jsp"%>
<style>
div.글정보 span:nth-child(1) { color: #aaa; }
div.글정보 span:nth-child(3) { color: #aaa; margin-left: 20px; }
div.글정보 span:nth-child(5) { color: #aaa; margin-left: 20px; }
div.내용 { min-height: 400px; }

.첨부파일목록 { margin-top: 50px; }
div.덧글 { margin: 20px 0 0 20px; }
div.덧글 .머리 { color: #888; border-top: 1px dashed #ddd; width: 850px;  padding: 5px; }
div.덧글 .머리 span { margin-right: 30px; }
div.덧글 .내용 { margin-left: 10px; white-space: pre-wrap; padding: 5px; min-height: 0px; }
</style>
</head>
<body>

<div class="container">
  <%@ include file="_menu_user.jsp"%>

  <div class="mainbody">
    <div class="controls pull-right">
      <a href="bbs_notice.jsp" class="btn btn-small">목록으로</a>
      <a class="btn btn-small">수정</a>
      <a class="btn btn-small">삭제</a>
      <a class="btn btn-small">파일 첨부하기</a>
    </div>
      
  <h1>공지사항</h1>
  <hr />
      
  <h2><small>[미분류]</small> 테스트 공지</h2>
  <hr />
      
  <div class="글정보">
    <span>작성자:</span>
    <span>admin</span>
    <span>작성일:</span>
    <span>2014-01-15 11:48:53</span>
  </div>
  <hr />
      
  <div class="내용">
<img style="border: 0px currentColor; vertical-align: top;" border="0" src="http://imgnews.naver.net/image/038/2014/01/15/yoyo201401142149570_59_20140115033305.jpg" width="540" height="357">
<p style="font-size: 9pt;">구글이 안드로이드 스마트폰에서 제공하는 응용 소프트웨어(앱) 장터인 ‘구글 플레이스토어’ 화면. 구글이 이통사와 나누는 판매 수익을 재조정하겠다고 통보해 이통사에 비상이 걸렸다. 김주영기자 will.hk.co.kr</p>
<p><br>앱장터 플레이마켓 유통 수익, 이통사 몫 대폭 삭감 통보. 27%서 15%로 줄이고 3%이던 구글 몫은 15%로.</p><p>월 수십억원 피해 이통사들 "우리 덕에 안드로이드 확산. 점유율 올랐다고 배짱 "반발 대안은 없어 발만 동동.</p><p>&nbsp;</p>
<p>구글이 스마트폰 어플리케이션(앱) 판매수익을 더 가져가겠다고 이동통신사들에게 통보했다. 현재 이동통신사와 구글의 앱 판매수익 배분비율은 9대 1인데, 이를 5대 5로 조정하겠다는 것이다. 이동통신사들은 '구글의 횡포'라며 반발하고 있지만, 앱을 파는 장터가 구글 소유라 뾰족한 대안이 없는 상태다.</p><p>&nbsp;</p>
<p>14일 관련업계에 따르면 안드로이드 스마트폰의 앱 장터인 '플레이스토어'에서 팔리는 유료 앱의 판매수익은 ▦우선 개발자가 70%를 갖고 ▦나머지 30% 가운데 27%는 이동통신사가 ▦3%는 구글이 갖는 구조다. 일반 상점에 비유하자면, 구글은 장터 소유자이고 이동통신사는 판매자이다.</p><p>&nbsp;</p>
<p>그런데 구글은 최근 이동통신사 몫을 15%로 낮추는 대신 자신들의 몫을 15%로 올리겠다고 통보해왔다. 구글은 현재 전세계 이동통신사들과 수익 배분 협상을 진행 중이다. 이동통신사들은 이에 대해 강하게 반발하고 있다. 한 통신사 관계자는 "9대1이었던 배분비율을 8대2나 7대3도 아니고 갑자기 5대5로 조정하는 게 어디있나"라고 분개했다. 또 다른 관계자는 "날벼락이나 다름없는 통보"라며 "월 수십억 원의 매출이 줄어들게 됐다"고 주장했다.</p><p>&nbsp;</p>
<p>그럼에도 불구하고 이동통신사들로선 대안이 없다. 안드로이드 스마트폰을 쓰는 이상, 구글의 요구를 거부할 방법이 없기 때문이다. 세계 최대 앱 장터인 플레이스토어를 대신 할 앱 스토어도 없다. 국내의 경우 SK텔레콤이나 삼성, 네이버 등이 앱 장터를 운영하고 있지만 구글의 플레이스토어와는 비교가 되지 않는다.</p><p>&nbsp;</p>
  </div>

  <hr />      
  <div class="controls pull-right">
    <a class="btn btn-small">한줄 덧글 작성</a>
  </div>
      
  <h2>한줄 덧글</h2>
      
  <div class="덧글">
    <div class="controls pull-right">
      <div class="btn-group">
        <a class="btn dropdown-toggle btn-small" data-toggle="dropdown">편집<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a onclick="">덧글 편집하기</a></li>
          <li><a onclick="">덧글 삭제</a></li>
        </ul>
      </div>
    </div>
    <div class="머리">
      <span>1.</span> 
      <span>admin</span>
      <span>2014-01-15 13:17</span>
    </div>
    <div class="내용">덧글 테스트2</div>
    </div>
    <div class="덧글">
      <div class="controls pull-right">
      <div class="btn-group">
        <a class="btn dropdown-toggle btn-small" data-toggle="dropdown">편집<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a onclick="">덧글 편집하기</a></li>
          <li><a onclick="">덧글 삭제</a></li>
        </ul>
      </div>
    </div>
    <div class="머리">
      <span>2.</span> 
      <span>admin</span>
      <span>2014-01-15 13:21</span>
    </div>
    <div class="내용">덧글 테스트1</div>
    </div>
  </div>
    

  <%@ include file="_footer.jsp"%>
</div>

</body>
</html>





