<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.sagar.jstl.Information"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center">
		<c:out value="${'JSTL CORE'}" />
	</h1>
	<hr>
	<!-- setting variable -->

	<c:set var="fname" value="Sagar" />
	<c:set var="lname" value="Gurung" />
	<p style="text-align: center">
		Welcome
		<c:out value="${fname} ${lname}" />
		in JSTL Practice!!
	</p>

	<!-- Remove variable  -->

	<c:remove var="lname" />
	<p style="text-align: center">
		After removing last name, Welcome
		<c:out value="${fname} ${lname}" />
	</p>

	<!-- if condition -->

	<p style="text-align: center">Test For eligible for vote or not. My
		age is 20</p>
	<c:set var="age" value="20" />
	<c:if test="${age >= 18}" />
	<p style="text-align: center">You are eligible to vote!!</p>

	<!-- if else condition -->

	<h3 style="text-align: center">Selection of Food: Pizza</h3>
	<c:set var="food" value="pizzas" />
	<c:choose>
		<c:when test="${food == 'pizza' }">
			<p style="text-align: center">You Selected Pizza!!!</p>
		</c:when>
		<c:when test="${food == 'burger' }">
			<p style="text-align: center">You Selected burger!!!</p>
		</c:when>
		<c:otherwise>
			<p style="text-align: center">You did not select anything!!</p>
		</c:otherwise>
	</c:choose>

	<!-- Loop in JSTL -->


	<h3 style="text-align: center">Displaying Students Information!!</h3>

	<%
		List<com.sagar.jstl.Information> information = new ArrayList<com.sagar.jstl.Information>();
		information.add(new Information("Lambu", "lambu@gmail.com", "bajapatan", "9287349273"));
		/* information.add(new Information("Kambu", "Kambu@gmail.com","Kajapatan", "9287349273"));
		information.add(new Information("Sambu", "Sambu@gmail.com","Sajapatan", "9287349273")); */
		pageContext.setAttribute("information", information);
	%>

	<c:forEach items="${information}" var="info">
		<p style="text-align: center">${info.getName()}</p>
		<p style="text-align: center">${info.getEmail()}</p>
		<p style="text-align: center">${info.getAddress()}</p>
		<p style="text-align: center">${info.getPhone()}</p>
	</c:forEach>

	<h3 style="text-align: center">Use of forTokens</h3>

	<c:set var="longname" value="sagar-is-very-cool-boy" />
	<c:forTokens items="${longname }" delims="-" var="name">
		<p style="text-align: center">${name}</p>

	</c:forTokens>

	<h3 style="text-align: center">Redirecting in JSTL!!</h3>

	<%-- <c:set var="url" value="0" scope="request" />
	<c:if test="${url<1}">
		<c:redirect url="http://javatpoint.com" />
	</c:if>
	<c:if test="${url>1}">
		<c:redirect url="http://instagram.com" />
	</c:if> --%>

	<hr>

	<h1 style="text-align: center">
		<c:out value="${'JSTL FUNCTIONS'}" />
	</h1>
	<hr>

	<h3 style="text-align: center">1. contains function</h3>

	<c:set var="String" value="Welcome to SAGAR GURUNG" />
	<c:if test="${fn:contains(String, 'SAGAR')}">
		<p style="text-align: center">Yes you are Sagar!!
		<p>
	</c:if>
	<c:if test="${fn:contains(String, 'GURUNG')}">
		<p style="text-align: center">Your surname is Gurung
		<p>
	</c:if>

	<h3 style="text-align: center">1. IgnoreCase function</h3>
	<c:if test="${fn:containsIgnoreCase(String, 'SAGAR')}">
		<p style="text-align: center">Yes you are Sagar!!
		<p>
	</c:if>
	<c:if test="${fn:containsIgnoreCase(String, 'gurung')}">
		<p style="text-align: center">Your surname is Gurung
		<p>
	</c:if>

	<h3 style="text-align: center">1. Endswith function</h3>
	<c:if test="${fn:endsWith(String, 'sagar')}">
		<p style="text-align: center">String ends with Sagar
		<p>
	</c:if>

	<c:if test="${fn:endsWith(String, 'GURUNG')}">
		<p style="text-align: center">String ends with Gurung
		<p>
	</c:if>
	
	<h3 style="text-align: center">4. Index function</h3>
	<p style="text-align: center">Index of Sagar : ${fn:indexOf(String, "SAGAR")}</p>  
<p style="text-align: center">Index of Gurung : ${fn:indexOf(String, "GURUNG")}</p>

<h3 style="text-align: center">5. Trim function</h3>

<c:set var="str1" value="Welcome to JSP        programming         "/>  
<p style="text-align: center">String1 Length is : ${fn:length(str1)} without trim function</p>  
 
<c:set var="str2" value="${fn:trim(str1)}" />  
<p style="text-align: center">String1 Length is : ${fn:length(str2)} using trim function</p>  
<p style="text-align: center"><c:out value ="${str2}" /></p> 

<h3 style="text-align: center">6. Startswith function</h3> 
<p style="text-align: center">The string starts with "The": ${fn:startsWith(String, 'The')}  </p>
<p style="text-align: center">The string starts with "Welcome": ${fn:startsWith(String, 'Welcome')}  </p>


<h3 style="text-align: center">7. split andjoin function</h3>

<c:set var="str" value="Welcome-to-JSP-Programming."/>  
<c:set var="strr" value="${fn:split(str, '-')}" /> 
<c:set var="strrr" value="${fn:join(strr, ' ')}" />   
<p style="text-align: center">After splitting <c:out value = "${strrr}"/></p>


<h3 style="text-align: center">8. Case function</h3>

<c:set var="mystring" value="Welcome-to-JSP-Programming."/> 
<p style="text-align: center"><c:out value = "${fn:toUpperCase(mystring) }" /></p>
<p style="text-align: center"><c:out value = "${fn:toLowerCase(mystring) }" /></p>


<h3 style="text-align: center">9. substring function</h3>

<c:set var="string" value="Hello my name is lambu gurung."/>

<p style="text-align: center"><c:out value = "${fn:substring(string, 3,13) }" /></p>
<p style="text-align: center"><c:out value = "${fn:substringAfter(string, 'Hello') }" /></p>
<p style="text-align: center"><c:out value = "${fn:substringBefore(string,'lambu') }" /></p>


<h3 style="text-align: center">10. replace function</h3>

<c:set var="string" value="i live in New york."/>

<p style="text-align: center"><c:out value = "${fn:replace(string,'New york','Pokhara')}" /></p>


	
</body>
</html>