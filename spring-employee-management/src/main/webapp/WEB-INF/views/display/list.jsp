<%@page
	import="com.valtech.springemployeemanagement.model.DepartmentModel"%>
<%@page
	import="com.valtech.springemployeemanagement.model.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Display</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

h2 {
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

td a {
	text-decoration: none;
	color: #3498db;
}

td a:hover {
	text-decoration: underline;
}

tfoot {
	background-color: #f2f2f2;
}

input[type="submit"] {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 15px;
	border: none;
	border-radius: 3px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<h2>Department Display</h2>

	<%
	List<EmployeeModel> employees = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	<%
	DepartmentModel departmentModel = (DepartmentModel) request.getAttribute("department");
	%>
	<table>
		<tr>
			<th>DepartmentId</th>
			<th>DepartmentName</th>
			<th>DepartmentLocation</th>
		</tr>
		<%
		request.setAttribute("department", departmentModel);
		%>
		<tr>
			<th>${department.deptId}</th>
			<th>${department.deptName}</th>
			<th>${department.deptLoc}</th>
		</tr>


		<tr>
			<td colspan="2">
				<form action="list" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>

	</table>

	<h2>List of Employees</h2>
	<table>
		<tr>
			<th>Id</th>
			<th></th>
			<th>Name</th>
			<th></th>
			<th>Age</th>
			<th></th>
			<th>Experience</th>
			<th></th>
			<th>Salary</th>
			<th></th>
			<th>Seniority</th>
			<th></th>
			<th>DepartmentId</th>
		</tr>

		<%
		for (EmployeeModel employee : employees) {
			request.setAttribute("employee", employee);
		%>

		<tr>
			<td>${employee.id }</td>
			<td></td>
			<td>${employee.name }</td>
			<td></td>
			<td>${employee.age}</td>
			<td></td>
			<td>${employee.experience}</td>
			<td></td>
			<td>${employee.salary}</td>
			<td></td>
			<td>${employee.seniority}</td>
			<td></td>
			<td>${employee.department.deptId}</td>
			<td><a href="delete?id=${employee.id }">Delete</a></td>
			<td></td>
			<td></td>
			<td><a href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add Employee" />
					</form>
				</td>
			</tr>
		</tfoot>

	</table>


</body>
</html>