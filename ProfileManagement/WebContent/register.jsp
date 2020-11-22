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
		<h1>Please Register !!</h1>
		<form method="post" action="loginRegister">
			<label>Email : </label><input type="email"name="email"><br> 
			<label>Password : </label><input type="password" name="password"><br>
			<label>First Name : </label><input type="text"name="firstname"><br> 
			<label>Last Name : </label><input type="text" name="lastname"><br>
			<label>City : </label><input type="text"name="city"><br> 
			<label>Country: </label><input type="text" name="country"><br>
			<label>Phone </label><input type="text"name="phone"><br> 
			<label>Education </label><input type="text" name="education"><br>
			<label>Profession</label><input type="text"name="profession"><br> 
			<label>Gender</label><input type="text" name="gender"><br>
			<br> <input type="submit" name="submit" value="register">
		</form>
	</div>
</body>
</html>