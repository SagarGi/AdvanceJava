<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>Please Login !!</h1>
		<form method="post" action="<%=request.getContextPath()%>/login">
			<label>Username : </label><br> <input type="text"
				name="username"><br> <label>Password : </label><br>
			<input type="password" name="password"><br> 
			<input type="submit" value="Login">
		</form>
	</div>
</body>
</html>