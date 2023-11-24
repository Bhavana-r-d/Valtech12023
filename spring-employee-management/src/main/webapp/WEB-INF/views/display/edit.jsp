<%@page import="com.valtech.springemployeemanagement.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            max-width: 600px;
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
            color: #fff;
            margin-left: 10px;
        }

        input[name="cancel"]:hover {
            background-color: #999;
        }
    </style>
</head>
<body>

<%EmployeeModel employee = (EmployeeModel) request.getAttribute("employee"); %>
<form method="post" action="save?id=<%= employee.getId()%>">
	<table>
		<tr>
			<td>EmployeeID</td>
			<td><input type="text" disabled="disabled" name="id" value="<%= employee.getId()%>"/></td>
		</tr>
		<tr>
			<td>EmployeeName</td>
			<td><input type="text" name="name" value="<%= employee.getName()%>"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="<%= employee.getAge()%>"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" value="<%= employee.getExperience()%>"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority" value="<%= employee.getSeniority()%>"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="<%= employee.getSalary()%>"/></td>
		</tr>
		<tr>
		<td>DepartmentId</td>
		<td><input type="text" name="department" value="<%=employee.getDepartment().getDeptId() %>"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Save"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>