<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Results</title>
</head>
<body>
<div class="container result-container">

<% String message = (String)request.getAttribute("message"); %>

    <% if (message != null) { %>

        alert('<%= message %>');

    <% } else {%>
        alert('<%=message%>');
    <%}%>

	 

</div>
</body>
</html>