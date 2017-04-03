<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<?xml version="1.0" encoding="UTF-8" ?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aufgabe 4.1b</title>
</head>
<body>
	<table>
		<c:forEach var="req" items="${header}">
			<c:choose>
				<c:when test="${req.key eq 'host'}">
					<tr>
						<td><c:out value="${req.key}" />: <b> <c:out
								value="${req.value}" /></b></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td><c:out value="${req.key}" />: <c:out
								value="${req.value}" /></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
</body>
</html>