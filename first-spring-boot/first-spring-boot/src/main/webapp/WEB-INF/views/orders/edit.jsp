<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%OrderModel order=(OrderModel) request.getAttribute("order"); %>
<body>

	<form method="post" action="save?id=<%= order.getId()%>">
		<table>
			<tr>
				<td>Id</td>
				<td><input  disabled="disabled"     type="text" name="id" value="<%=order.getId() %> " /></td>
			</tr>

			<tr>
				<td>Item</td>
				<td><input type="text" name="item"  value="<%=order.getItem() %> " /> </td>
			</tr>

			<tr>
				<td>ItemCount</td>
				<td><input type="text" name="itemCount" value="<%=order.getItemCount() %> " /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="description" value="<%=order.getDescription() %> "/></td>
			</tr>

			<tr>
				<td>OrderDate</td>
				<td><input type="text" name="orderDate" value="<%=order.getOrderDate() %> "/></td>
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" name="submit"value="Create" />
				 <input type="submit" name="cancel" value="Cancel" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>