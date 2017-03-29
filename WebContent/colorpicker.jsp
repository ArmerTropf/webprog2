<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="<% Cookie [] myCookies;  myCookies = request.getCookies();  out.println(myCookies[0].getValue()); %> ">
<li><p><b>First Name:</b>
  <%
  	Cookie test = new Cookie("homo1",request.getParameter("color"));
  	test.setMaxAge(60*60*24*30);
  	response.addCookie(test);
  	
  	out.println(request.getParameter("color"));
  	
  	out.println(request.getParameter("myimage.x"));
  	
  %>
  

</p>
</li>
</body>
</html> 