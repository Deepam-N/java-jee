<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register user</title>
</head>
<body>
	<%
		String errorMessage = (String)request.getAttribute("errorMessage");
		if (errorMessage != null) {%>
		<h3 style="color:red;"><%=errorMessage%></h3>
	<%} %>
	
	
	<form action="register" method="post">
		<fieldset>
			Username:<input type="text" name="uname"/><br>
			Password:<input type="password" name="pass"/><br><br>
		</fieldset>
		
		<fieldset>
			<% Map<String, String> countries = (Map)session.getAttribute("mapOfCountries"); %>
			Select your country: <select name="country">
			<%
				for(String country:countries.keySet()) {%>
					<option value=<%=country%>><%=countries.get(country)%></option>
				<% }
			%>
			</select><br><br>
		</fieldset>
		
		<fieldset>
			<legend>Gender: </legend>
			<input type="radio" name="gender" id="male" value="Male"/>
			<label for="male">Male</label><br>
			<input type="radio" name="gender" id="female" value="Female"/>
			<label for="female">Female</label><br>
			<input type="radio" name="gender" id="other" value="Other"/>
			<label for="other">Other</label><br><br>
		</fieldset>
		
		<input type="submit" value="Register"/>
	</form>
	
	<%
		String registrationSuccess = (String)request.getAttribute("registrationSuccess");
		if (registrationSuccess != null) {%>
		<h3><%=registrationSuccess%></h3>
		<a href="login.jsp">Login</a>
	<%} %>
	
</body>
</html>