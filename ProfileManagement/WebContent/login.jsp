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
		<p>${message}</p>
		<p>${successmessage}</p>
		<form method="post" action="loginRegister">
			<label>Email : </label><br> <input type="email"
				name="email"><br> <label>Password : </label><br>
			<input type="password" name="password"><br> <input
				type="submit" name="submit" value="login"> <a
				href="register.jsp">Register</a>
		</form>
	</div>
</body>
</html>