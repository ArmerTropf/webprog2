<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	ue4.1
	<br/>
	<%
		java.util.Enumeration headerNames = request.getHeaderNames();
		while ( headerNames.hasMoreElements() )
		{
		String headerNameKey = (String) headerNames.nextElement();
		String headerNameValue = request.getHeader( headerNameKey );
		
		if(headerNameKey.equals("host"))
		{
			%> 
				<%= headerNameKey %>: <b> <%= headerNameValue %> </b> <br/>
			<% 
		}
		else
		{
			out.println(headerNameKey + ": " + headerNameValue + "");
		}
	
	}
	%>
</body>
</html>