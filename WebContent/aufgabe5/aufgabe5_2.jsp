<%@ page import="aufgabe5.Aufgabe5_2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aufgabe 4.3</title>
</head>
<body>
<H1>MyProperties</H1>
	<table>
		<jsp:useBean id="personsData" type="aufgabe5.PersonsDataBean" scope="request" />
		
		<c:forEach var="item" items="${personsData.names }">
			<tr>
				<td> <a href="./Aufgabe5_2?action=${item.key}">${item.key}</a></td>
				<td>${item.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>