<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer List</title>
 <link href="/css/new.css" rel="stylesheet">
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<jsp:include page="../header.jsp" /><br><br>
  <h2>List of Employee</h2>
  <a href="/emp_add"><button>Add new employee</button></a><br><br>
    	    <form method="post" action="emp_search">
             	<input type="text" placeholder="Name" name="emp_name" >
                <input type="text" placeholder="Organization" name="org_name" >
                <input type="submit" value="Search"><br>
  		</form>
  <br>
  
                
  <table border="3">
   <thead>
    <tr>
     <th scope="row">Id</th>
     <th scope="row">Name</th>
     <th scope="row">Head</th>
     <th scope="row">Organization</th>
     <th scope="row">Delete</th>
     <th scope="row">Edit</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${employee_list}" var="employee" >
     <tr>
      <td>${employee.getValue(0)}</td>
      <td>${employee.getValue(1)}</td>
      <td>${employee.getValue(2)}</td>
      <td>${employee.getValue(3)}</td>
      <td><a href="employee_delete?id=${employee.getValue(0)}"><button>Delete</button></a></td>
      <td><a href="emp_edit/${employee.getValue(0)}">Edit</a></td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <a href="/show_more"><button>Show more</button></a><br><br>
</body>
</html>