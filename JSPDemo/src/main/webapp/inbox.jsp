<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.List" errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inbox</title>
</head>
<body>
	<%-- <!-- Declaration tag -->
	<%!
		int x;
		static int y;
		String name = "john doe";
	%>
	<!-- Scriptlet tag -->
	<%
		x = 100;
		y = 200;
		out.print(x+y);		//out is an implicit object
	%>
	<!-- Expression tag (can be used w HTML tags)-->
	<h3><%=name%></h3> --%>
	
	<%
		String name = request.getParameter("unam");
		String password = request.getParameter("pass");
		String country = "India";
		
		List<String> al = new ArrayList<>();
		al.add("Singing");
		al.add("Dancing");
		al.add("Cooking");
		
		if (name.equals("admin") && password.equals("123")) {
			/* response.sendRedirect("final.jsp"); */
			
			/* RequestDispatcher rd = request.getRequestDispatcher("final.jsp");
			request.setAttribute("country", country);
			rd.forward(request, response); */
			
			session.setAttribute("country", country);
			session.setAttribute("uname", name);
			
			session.setAttribute("hobbies", al);
			
			response.sendRedirect("final.jsp");
		}
	%>
</body>
</html>