<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aufgabe 4.1b</title>
</head>
<body>
<H1>MyProperties</H1>
	<table>
		<jsp:useBean id="obj" class="aufgabe4.Aufgabe4_2" />
		<c:forEach var="item" items="${obj.myProperties}">
			<tr>
				<td>${item.key}</td>
				<td>${item.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>