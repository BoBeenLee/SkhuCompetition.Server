<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<form:form commandName="message" action="send.do">
	<form:input path="msg1"/>
	<input type="submit" value="Save Change" />
</form:form>