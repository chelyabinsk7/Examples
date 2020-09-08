  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add organization</title>
</head>
<body>
<jsp:include page="../header.jsp" /><br><br>	
	    <form method="post" action="add1">
                Name of organization: <br>
                <input type="text" placeholder="Name of organization" name="org_name" required>
                <br>Parent's ID (if there's)<br>
                <input type="number" placeholder="id by parent organization" name="id_parent">
                <br><input type="submit" value="Add organization">
  		</form>
</body>
</html>