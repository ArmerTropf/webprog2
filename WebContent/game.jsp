<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	bgcolor="<%Cookie[] myCookies = null;
			myCookies = request.getCookies();
			int hit = 0;
			for (int i = 0; i < myCookies.length; i++) {
				out.println("name: " + myCookies[i].getName());
				if (myCookies[i].getName() == "color") {
					hit = 1;
				}
			}
			/* if (hit == 0)
				
				//response.sendRedirect("colorpicker.jsp");
			else
				out.println(myCookies[0].getValue()); */
		
				%>">
	<form action="game.jsp" method="GET">
		Click Image: <input type="image" name="myimage"
			src="https://images-na.ssl-images-amazon.com/images/I/51SyNCviL7L.jpg"
			width="600">
	</form>
	<%
		session.setMaxInactiveInterval(2);

		if (session.isNew()) {
			out.println("Neue Session\n");
			session.setAttribute("punkte", 0);
		} 
		
		if (request.getParameter("myimage.y") != null )  {
			
		
			int aktuellePunkte = (int)session.getAttribute("punkte");
			out.println("Aktuelle Punkte: " + session.getAttribute("punkte"));

			if (aktuellePunkte == 3) {
				response.sendRedirect("chooseWin.jsp");
			}

			String x = request.getParameter("myimage.x");
			String y = request.getParameter("myimage.y");
			
			if (x.equals(y)) {
				int pointsCounter = (Integer) session.getAttribute("punkte");
				out.println("Vorhandene Punkte: " + pointsCounter);
				pointsCounter++;
				out.println("Neue Punkte: " + pointsCounter);
				session.setAttribute("punkte", pointsCounter);

			} else {
				out.println("KEIN Treffer");
			}

		}
	%>

</body>
</html>