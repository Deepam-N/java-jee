<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register employee</title>
</head>
<body>
	<%-- <jsp:useBean id="emp" class="model.Employee" scope="request"></jsp:useBean>
	<jsp:setProperty property="*" name="emp"/>
	
	<jsp:getProperty property="eID" name="emp"/>
	<jsp:getProperty property="eName" name="emp"/>
	<jsp:getProperty property="eAddress" name="emp"/>
	
	<jsp:forward page="NextPage.jsp"></jsp:forward>		<!-- using request scope -->
	
	${param.eID}
	${param.eName}
	${param.eAddress}
	
	${2 eq 3}
	${2 lt 3}
	${2 gt 3} --%>
	
	<jstl:set var="empAddress" value="${param.eAddress}" scope="session"></jstl:set>
	<%-- <jstl:if test="${param.eName eq 'admin' }">
		<jstl:out value="Welcome admin"></jstl:out>
		<jstl:redirect url="admin.jsp"></jstl:redirect>
	</jstl:if>
	
	<jstl:if test="${param.eName eq 'user' }">
		<jstl:out value="Welcome user"></jstl:out>
		<jstl:redirect url="user.jsp"></jstl:redirect>
	</jstl:if> --%>
	
	<jstl:choose>
		<jstl:when test="${param.eName eq 'admin' }">
			<jstl:out value="Welcome admin"></jstl:out>
		</jstl:when>
		<jstl:when test="${param.eName eq 'user' }">
			<jstl:out value="Welcome user"></jstl:out>
		</jstl:when>
		<jstl:otherwise>
			<jstl:out value="Welcome super user"/>
		</jstl:otherwise>
	</jstl:choose>
	
	<a href=<jstl:url value="admin.jsp"/>>Click Here</a>
	
</body>
</html>