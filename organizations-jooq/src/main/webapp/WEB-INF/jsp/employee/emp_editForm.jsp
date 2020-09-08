<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit employee</title>
	</head>
	
	<body>
		<jsp:include page="../header.jsp"/><br><br> 	
		
		<p>What's your edit?</p>
		
		<form:form method="POST" action="/emp_editsave">    
			<table> 
	           	<tr>  
					<td></td>    
					<td><form:hidden path="id" /></td>  
				</tr> 
				<tr>    
					<td>Name: </td>   
					<td><form:input path="EmpName" type="text" required="required"/></td>  
				</tr> 
				<tr>    
					<td>ID Organization :</td>    
					<td><form:input path="IdOrg" type="number"/></td>  
				</tr> 
				<tr>    
					<td>ID head :</td>    
					<td><form:input path="IdHead" type="number" min="1"/>*</td>  
				</tr>
				<tr>    
					<td> </td>    
					<td><input type="submit" value="Edit Save" /></td>    
				</tr>    
			</table>    
		</form:form> 
		
		<p>*Employee and head must be from the same organization</p>
	</body>
</html>