<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Next page</title>
</head>
<body>
	<%-- <jsp:useBean id="emp" type="model.Employee" scope="request"></jsp:useBean>	<!-- Bean coming from RegisterEmployee -->
	
	<jsp:getProperty property="eID" name="emp"/>
	<jsp:getProperty property="eName" name="emp"/>
	<jsp:getProperty property="eAddress" name="emp"/> --%>
	${2 eq 3}
	<%! int x=90; %>
	 <% x=x+1;%>
	 <%=x%>
</body>
</html>