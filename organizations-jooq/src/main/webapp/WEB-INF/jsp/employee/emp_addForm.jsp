<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>AddForm</title>
	</head>
	
	<body>
		<jsp:include page="../header.jsp"/><br>
				
		<p>New employee:</p>
	
		<form method="post" action="add2">
			<input type="text" placeholder="Name" name="emp_name" required><br><br>
			<input type="number" placeholder="id organization" name="id_org" required min="1"><br><br>
			<input type="number" placeholder="id head" name="id_head" min="1">*<br>
			<input type="submit" value="Add employee">
		</form>
		
		<p>*Employee and head must be from the same organization</p> 
	</body>
</html>