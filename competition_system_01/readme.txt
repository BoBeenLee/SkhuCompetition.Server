궁금 사항
1. annotation-config, component-scan, ContextLoaderListener 의 역할
2. org.mybatis.spring.mapper.MapperScannerConfigurer 사용법
js, css 참조 부분

<!-- 항목별 -->
<link rel="stylesheet/less" type="text/css" href="main.less">

<!-- 달력 CSS - 메인 -->
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.css"
	rel='stylesheet' />
<link
	href="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.print.css"
	rel='stylesheet' media='print' />
	
	
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<script src="//code.jquery.com/jquery.js"></script>

<!-- 달력 JS - 메인 -->
<script
	src="//cdnjs.cloudflare.com/ajax/libs/fullcalendar/1.6.4/fullcalendar.min.js"></script>
	
	
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>	
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-beta.7/angular.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/1.7.0/less.min.js"></script>

<!-- CKEditor -->
<script src="../css/ckeditor/ckeditor.js"></script>

틀 구성도 
- 메인 틀
공지사항 박스
게시판 박스
일정 박스
- 서브1 틀
사이트바
컨텐츠
- 서브2 틀
컨텐츠

공지사항
1. 다지인 꾸미기 - 디자인 확정
2. 페이지 넘김 메인은 다 구성해야함.

세무 메뉴사항
공지사항 - 공지사항
경진대회 - IT 경진대회, 소프트웨어 경진대회
대회자료 - 출품작, 자료실, 
QA - F.A.Q, 1:1 게시판? - 고려해볼것.

* 마이페이지 
학생 - 회원수정, Team ( 경진대회 신청/변경 ), Competition ( 자료 upload, download ) - sub
교수 - 회원수정,  Team ( 대회 진행(제안서평가/최종평가 구별,  평가 ) , Competition, Score
관리자 - Board, User 

그외 - 로그인, 

Competition 
- 학생 = 해당 게시판 자료 업로드
- 교수 = 해당 게시판 점수 관리, 팀별 자료 관리.

Team
- 학생 = 가입한 팀들을 보여줌.
- 교수 = 해당 게시판에 따라 팀들에 대한 정보, 점수를 보여줌.

학생
Team -  체크박스,	대회명, 팀명, 팀타입, 팀생성날짜
Competition - 각 대회에 따라  번호, 기한, 점수, 내용, 자료 업로드, 다운로드

교수 
Team - 팀명, 팀타입, 총합점수, 수상
Competition - 각 대회에 따라 번호, 팀명, 기한, 점수, 내용, 다운로드
Score - 각 대회에 따라 1등, 2등, 3등, 인기상 등등 관리


-- 작업 중 --
1. index.jsp 타일즈로 연동했음 다른 sub 파일도 연동해볼것.


