<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>Home page</title>
</head>

<body>
	<h2>This is home page</h2>
	<br>
	<hr>
	
	<!-- Display current user name and role -->
	
	<p>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	
	<!-- Acces only for manager-roles -->
	<security:authorize access="hasRole('MANAGER')">
	
	<!-- Link to /leaders for managers -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Link for managers</a> (Only)
	</p>
	
	</security:authorize>
	
	
	<security:authorize access="hasRole('ADMIN')">
	<!-- Link to /systems for admins -->
	<p>
		<a href="${pageContext.request.contextPath}/systems">Link for IT</a> (Only for admins)
	</p>
	</security:authorize>
	
	
	<!-- Button for logout -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout" />
	</form:form>
	
	
</body>

</html>