<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="jstlfmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="jstlfun" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome admin!</title>
</head>
<body>
	Welcome admin! You're address is: 
	${sessionScope.empAddress}<br>
	<jstlcore:set var="price" value="190000.765" scope="session"/>
	
	<jstlcore:set var="curdate" value="<%=new java.util.Date()%>" scope="session"></jstlcore:set>
	
<%-- 	<jstlfmt:setLocale value="en_US"/>--%>	

	<jstlfmt:formatNumber value="${price}" type="currency"/><br>
	<jstlfmt:formatNumber value="${price}" maxFractionDigits="2"/><br>
	
	<jstlfmt:formatDate value="${curdate}" type="both" dateStyle="short" timeStyle="short"/><br>
	<jstlfmt:formatDate value="${curdate}" type="both" dateStyle="long" timeStyle="long"/><br>
	<jstlfmt:formatDate value="${curdate}" type="both" dateStyle="medium" timeStyle="medium"/><br><br>
	
	<jstlcore:set var="name" value="John Doe"/>
	<jstlcore:if test="${jstlfun: startsWith(name, 'J')}">
		<jstlcore:out value="Welcome"/><br>
		<jstlcore:out value="${jstlfun:toUpperCase(name) }"/><br>
		<jstlcore:out value="${jstlfun:toLowerCase(name) }"/><br>
	</jstlcore:if>
	
</body>
</html>