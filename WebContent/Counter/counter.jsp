<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body bgcolor="#50ff50">
	<jsp:useBean id="counterData" type="Counter.CounterDataBean" scope="request" />
	<h1>Trennung von Verarbeitung und Pr¨asentation</h1>
	Ghghgh${counterData.value } Aufruf des URL
</body>
</html>