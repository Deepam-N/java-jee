<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<%
		String errorMessage = (String)request.getAttribute("errorMessage");
		if (errorMessage != null) {%>
		<h3 style="color:red;"><%=errorMessage%></h3>
	<%} %>
	
	<form action="login" method="post">
		<fieldset>
			Username:<input type="text" name="uname"/><br>
			Password:<input type="password" name="pass"/><br><br>
		</fieldset>
		
		<input type="submit" value="Login"/>
	</form>
	
</body>
</html>