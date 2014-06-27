<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="header row">	
	<span class="main-title"><a href="main/main.do">IT Competition System</a></span> 

	<sec:authorize access="isAnonymous()" >
	<a href="user/register.do" class="box box-register btn btn-default pull-right">회원가입</a> 
	<a href="user/login.do" class="box box-login btn btn-default pull-right">로그인</a>
	</sec:authorize>
	<sec:authorize access="!isAnonymous()" >
	<a href="mypage/modify.do?cmd=chkpw" class="box box-mypage btn btn-default pull-right">마이페이지</a> 
	<a href="logout.do" class="box box-logout btn btn-default pull-right">로그아웃</a>
	<a class="box box-name btn btn-default pull-right"><sec:authentication property="principal.username"/>님 </a>
	</sec:authorize>
</div>
<div class="menu row">
	<ul class="box-menu nav nav-pills nav-justified">
		<li><a href="sub1/board.do?bid=1">공지사항</a></li>
		<li><a href="sub/board.do?bid=2">경진대회</a></li>
		<li><a href="sub1/board.do?is=1">대회자료</a></li>
		<sec:authorize access="!isAnonymous()" >
		<li><a href="team/managetm.do">팀</a></li>
		</sec:authorize>
		<li><a href="sub1/board.do?bid=4">QnA</a></li>
	</ul>
</div>