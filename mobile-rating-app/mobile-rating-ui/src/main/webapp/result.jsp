<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Fancy Phone Number Ranker Result</title>
<style>
/* styles.css */
body {
	font-family: 'Arial', sans-serif;
	background-color: #f8f8f8;
	margin: 0;
	padding: 0;
	text-align: center;
	align-items: center;
}

h1 {
	color: #333;
}

p {
	color: #555;
}

ol {
	list-style-type: none;
	padding-left: 20px;
}

li {
	margin-bottom: 8px;
	color: #333;
}

a {
	color: #337ab7;
	text-decoration: none;
}

a:hover {
	color: #23527c;
	text-decoration: underline;
}

/* Add more styles as needed */
</style>
</head>
<body>
<%! int count = 0; %>
	<h1>Fancy Phone Number Ranker Result</h1>

	<p>Ranked Phone Numbers:</p>
	<ol>
		<%-- <c:forEach items="${rankedPhoneNumbers}" var="phoneNumber">
			<li>${phoneNumber}</li>
		</c:forEach> --%>
		<%
		List<String> phoneNumbers = (List<String>) request.getAttribute("rankedPhoneNumbers");
		%>
		<%
		for (String phoneNumber : phoneNumbers) {
			count++;
		%>
		<li><%=count %>. &nbsp <%=phoneNumber%></li>
		<%
		}
		%>
	</ol>
	<p>
		<a href="index.jsp">Go back</a>
	</p>
</body>
</html>