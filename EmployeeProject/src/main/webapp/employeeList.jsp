<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<p class="navbar-brand"> Employee Management Application </p>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list" class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employee</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>EmployeeID</th>
						<th>EmployeeName</th>
						<th>Age</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>Salary</th>
						<th>DeptartmentID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="Employee" items="${getAllEmployees}">

						<tr>
							<td><c:out value="${Employee.id}" /></td>
							<td><c:out value="${Employee.name}" /></td>
							<td><c:out value="${Employee.age}" /></td>
							<td><c:out value="${Employee.experience}" /></td>
							<td><c:out value="${Employee.seniority}" /></td>
							<td><c:out value="${Employee.salary}" /></td>
							<td><c:out value="${Employee.deptId}" /></td>
							<td><a href="edit?id=<c:out value='${Employee.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value='${Employee.id}' />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="show?id=<c:out value='${Employee.id}' />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>