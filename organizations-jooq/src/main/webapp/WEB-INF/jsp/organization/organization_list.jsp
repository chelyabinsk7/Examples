<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Organization</title>
 <link href="/css/new.css" rel="stylesheet">
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
<jsp:include page="../header.jsp" /><br><br>
  <h2>List of Organizations</h2>
  
 <a href="/org_add"><button>Add new organization</button></a><br><br>
 
   	    <form method="post" action="../org_search">
                <input type="text" placeholder="Organization name" size="30" name="org_name" >
                <input type="submit" value="Search"><br>
  		</form>
  		
  <table border="3">
   <thead>
    <tr>
     <th scope="row">Id</th>
     <th scope="row">Organization</th>
     <th scope="row">Parent</th>
     <th scope="row">Total</th>
     <th scope="row">Delete</th>
     <th scope="row">Edit</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${organization_pagelist}" var="organization">
     <tr>
      <td>${organization.getValue(0)}</td>
      <td>${organization.getValue(1)}</td>
      <td>${organization.getValue(2)}</td>
      <td>${organization.getValue(3)}</td>
      <td><a href="../org_delete?id=${organization.getValue(0)}"><button>Delete</button></a></td>
      <td><a href="../org_edit/${organization.getValue(0)}">Edit</a></td>
     </tr>
    </c:forEach>
   </tbody>
  </table> 
  <br>
  		
        <c:forEach begin="1" end="${total_page}" var="page">
        	<a href="/organization/${page}"><c:out value="${page}"/></a>
		</c:forEach>  
</body>
</html>