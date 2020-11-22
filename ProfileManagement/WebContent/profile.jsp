<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/profilemanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String userid = "root";
	String password = "";
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>

	 <h1>Retrieve data from database in jsp</h1>
	<table border="1">
		<tr>
			<td>Email</td>
			<td>Password</td>
			<td>first name</td>
			<td>last name</td>
			<td>City</td>
			<td>Country</td>
			<td>Phone</td>
			<td>Education</td>
			<td>Profession</td>
			<td>Gender</td>


		</tr>
		<%
			String reqEmail = (String) request.getAttribute("email");
			try {
				connection = DriverManager.getConnection(connectionUrl, userid, password);
				statement = connection.createStatement();
				String sql = "select * from userdb where email = '" + reqEmail + "'  ";
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getString("email")%></td>
			<td><%=resultSet.getString("password")%></td>
			<td><%=resultSet.getString("firstname")%></td>
			<td><%=resultSet.getString("lastname")%></td>
			<td><%=resultSet.getString("city")%></td>
			<td><%=resultSet.getString("country")%></td>
			<td><%=resultSet.getString("phone")%></td>
			<td><%=resultSet.getString("education")%></td>
			<td><%=resultSet.getString("profession")%></td>
			<td><%=resultSet.getString("gender")%></td>
		</tr>
		<%
			}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	</table>
	
	<%
	HttpSession mysession = request.getSession(); // setting a session
	mysession.setAttribute("email", reqEmail);
	%>
	<a href = "update.jsp">Update</a>
</body>
</html>