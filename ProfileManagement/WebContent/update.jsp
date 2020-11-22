<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%  HttpSession mysession = request.getSession();
	String s =  (String)mysession.getAttribute("email"); 
	out.println(s);
	%>
</body>
</html>