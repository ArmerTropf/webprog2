<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Farbe aussuchen</title>
</head>
<body
	bgcolor="<% Cookie[] myCookies;
			myCookies = request.getCookies();
			if (myCookies[0] != null) {
				out.println(myCookies[0].getValue());
			}%> ">
			
	<form action="colorpicker.jsp" method="GET">
		Farbe aussuchen: <br>
		<input type="text" name="color"> 
		<input type="submit" value="Submit" />
		<%
			Cookie test = new Cookie("color", request.getParameter("color"));
			test.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(test);


		%>
<a href="game.jsp">lets play</a>

	</form>
</body>
</html>
