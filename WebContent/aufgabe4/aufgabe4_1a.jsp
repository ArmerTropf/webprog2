<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aufgabe 4.1a</title>
</head>
<body>
	<table>
		<%
			Enumeration<String> enumeration = request.getHeaderNames();
			while (enumeration.hasMoreElements()) {
				String name = (String) enumeration.nextElement();
				String value = request.getHeader(name);
				if (name.equals("host")) {
					out.println("<tr>");
					out.println("<td>" + name + "</td>");
					out.println("<td><b>" + value + "</b></td>");
					out.println("</tr>");
				} else {
					out.println("<tr>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + value + "</td>");
					out.println("</tr>");
				}
			}
		%>
	</table>
</body>
</html>