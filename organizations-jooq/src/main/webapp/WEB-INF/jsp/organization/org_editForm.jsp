<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit organization</title>
	</head>
	
	<body>
		<jsp:include page="../header.jsp"/><br><br>	
		
		<p>What's your edit?</p>

		 		<form:form method="POST" action="/org_editsave">    
			<table>   
			 
				<tr>  
					<td></td>    
					<td><form:hidden path="id" /></td>  
				</tr>   
				
				<tr>    
					<td>Name of organization: </td>   
					<td><form:input path="OrgName" type="text" required="required" /></td>  
				</tr> 
	   
				<tr>    
					<td>Id of parent:</td>    
					<td><form:input path="IdParent" type="number" min="1" /></td>  
				</tr>   
	
				<tr>    
					<td> </td>    
					<td><input type="submit" value="Edit Save" /></td>    
				</tr>
				    
			</table>    
		</form:form>
	</body>
</html>