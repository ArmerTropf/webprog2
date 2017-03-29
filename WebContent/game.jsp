<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="game.jsp" method="GET">
		Click Image: <input type="image" name="myimage"
			src="https://mdn.mozillademos.org/files/2917/fxlogo.png" width="50">
	</form>
	<%
		session.setMaxInactiveInterval(5);
	 	if (session.isNew()){
	      
	      
	      
	   } 
		

		String x = request.getParameter("myimage.x");
		String y = request.getParameter("myimage.y");
		out.println(x + " " + y);

		if (x.equals(y)) {
			out.println("Treffer");
			session.setAttribute("punkte", "1");
		} else {
			out.println("KEIN Treffer");
		}
	%>

</body>
</html>