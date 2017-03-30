<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Game</title>
</head>
<body
	bgcolor="<%Cookie[] myCookies = null;
			myCookies = request.getCookies();
			if (myCookies != null) {
				int hit = 0;
				Cookie co = null;
				for (int i = 0; i < myCookies.length; i++) {
					if (myCookies[i].getName().equals("color")) {
						hit = 1;
						co = myCookies[i];
					}
				}
				if (hit == 0)
					response.sendRedirect("colorpicker.jsp");
				else
					out.println(co.getValue());
			} else
				response.sendRedirect("colorpicker.jsp");%>
">
	<%
		session.setMaxInactiveInterval(30);

	/* 	if (session.isNew()) {
			out.println("Neue Session\n");
			
		} */

		if (request.getParameter("myimage.y") != null) {

			int aktuellePunkte = (int) session.getAttribute("punkte");
			out.println("Aktuelle Punkte: " + session.getAttribute("punkte"));

			if (aktuellePunkte == 3) {
				response.sendRedirect("chooseWin.jsp");
			}

			String x = request.getParameter("myimage.x");
			String y = request.getParameter("myimage.y");

			if (x.equals(y)) {
				int pointsCounter = (Integer) session.getAttribute("punkte");
				pointsCounter++;
				session.setAttribute("punkte", pointsCounter);
				out.println("Treffer");

			} else {
				out.println("KEIN Treffer");
			}

		}
	%>
	<form action="game.jsp" method="GET">
		<input type="image" name="myimage"
			src="https://images-na.ssl-images-amazon.com/images/I/51SyNCviL7L.jpg"
			width="500">
	</form>



</body>
</html>