<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Details</title>
</head>
<body>
<% Department dept=(Department) request.getAttribute("dept"); %>
	<table>
		<tr>
			<td>ID</td>
			<td><%=dept.getId()%></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><%=dept.getName()%></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><%=dept.getAge()%></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><%=dept.getExperience()%></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><%=dept.getSeniority()%></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><%=dept.getSalary()%></td>
		</tr>
		<tr>
			<td colspan="2">
				<form action="deptCtrl" method="post">
					<input type="submit" name="submit" value="First" />
					 <input type="submit" name="submit" value="Previous" /> 
					 <input type="submit" name="submit" value="Next" /> 
					 <input type="submit"name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>

</body>
</html>