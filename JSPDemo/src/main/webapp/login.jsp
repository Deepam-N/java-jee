<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp" import="java.util.Map"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
	<%--
		String errorMessage = (String)request.getAttribute("errorMessage");
		if (errorMessage != null)
		<h3><%=errorMessage%></h3>
	--%>
	${sessionScope.errorMessage}

	<form action="login" method="post">
		Username:<input type="text" name="uname"/><br>
		Password:<input type="password" name="pass"/><br>
		
		Select your country: <select name="country">
			<jstl:forEach var="countryMap" items="${sessionScope.mapOfCountries}">
				<option value="${countryMap.key}">${countryMap.value}</option>
				<jstl:out value="${countryMap.value}"></jstl:out>
			</jstl:forEach>
		</select><br>
		<input type="submit" value="Login"/>
		
		<%-- <%@include file="index.html" %> --%>
	</form>
</body>
</html>
<%-- <% Map<String, String> countries = (Map)session.getAttribute("mapOfCountries"); %> --%>
		
		<%-- Select your country: <select name="country">
		<%
			for(String country:countries.keySet()) {%>
				<option value=<%=country%>><%=countries.get(country)%></option>
			<% }
		%>
		</select><br> --%>