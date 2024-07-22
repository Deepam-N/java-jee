<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Final</title>
</head>
<body>
	<%-- Welcome, <%=request.getParameter("uname")%>.
	
	<%
		String country = (String)request.getAttribute("country");
	%>
	 I live in <%=country%>. --%>
	 
	 <%
	 	String country = (String)session.getAttribute("country");
	 	String username = (String)session.getAttribute("uname");
	 	List<String> hobbies = (List)session.getAttribute("hobbies");
	 %>
	 <h3>Welcome <%=username%>, from <%=country%></h3>
	 Select your hobby:<select>
	 <%
	 for (String h:hobbies) {%>
	 	<option value=<%=h%>><%=h%></option>
	 <%} %>
	 </select>
</body>
</html>