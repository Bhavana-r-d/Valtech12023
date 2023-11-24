<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Employee</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

form {
	max-width: 400px;
	margin: 20px auto;
	background: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
}

td {
	padding: 10px;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	margin-bottom: 10px;
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

input[name="cancel"] {
	background-color: #ccc;
	color: #000;
	margin-left: 10px;
}

input[name="cancel"]:hover {
	background-color: #999;
}
</style>
</head>
<body>
	<form method="post" action="save">
		<table>
			<tr>
				<td>EmployeeID</td>
				<td><input type="text" disabled="disabled" name="id" /></td>
			</tr>
			<tr>
				<td>EmployeeName</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience" /></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" /></td>
			</tr>
			<tr>
				<td>DepartmentId</td>
				<td><input type="text" name="department" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="submit"
					value="Create" /> <input type="submit" name="cancel" value="Cancel" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>