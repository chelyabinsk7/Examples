<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<title>Custom login page</title>
	<style>
		.failed {
			color: red;
		}
	</style>
</head>

<body>
<h3>My custom login page</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				
		<c:if test="${param.error != null}">
			<i class="failed">Invalid username or password</i>
		</c:if>
		
		<p>
		User name: <input type="text" name="username"/>
		</p>
		<p>
		Password: <input type="text" name="password"/>
		</p>
		
		<input type="submit" value="Login"/>
	</form:form>			

</body>

</html>

