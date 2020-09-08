<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Save customer</title>

		<link rel="stylesheet" type="text/css" 
		href="${pageContext.request.contextPath}/resources/css/add-cusctomer-style.css">
			
	</head>
	
	<body>
		<div id="wrapper">
			</div id="header">
				<h2>Customer manager</h2>
			</div>
		<div>
		
		<div id="container">
			<h3>Save customer</h3>
			<form:form action="saveCustomer" method="POST" modelAttribute="customer">
				<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td><label>First name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><form:input path="email" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; both;"></div>
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</body>
</html>