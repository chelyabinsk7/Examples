<html>
<body>

<h3>Spring CRM REST Demo</h3>

<hr>

<a href="${pageContext.request.contextPath}/api/customers">List of customers</a>
<br><br><br><br>
1. (GET) /customers - all customers <br><br>
2. (GET) /customers/{customerId} - one customer <br><br>
3. (POST) /customers - new customer. Example: <br>
{<br>
    "firstName" : "Anna",<br>
    "lastName" : "Maria",<br>
    "email" : "annamaria@gmail.com"<br>
}
<br><br>
4. (PUT) /customers - edit customer. Example: <br>
{<br>
    "id" : 1,<br>
    "firstName" : "Anna",<br>
    "lastName" : "Maria",<br>
    "email" : "anna-maria@gmail.com"<br>
}
<br><br>
5. (DELETE) /customers/{customerId} - delete customer <br>

</body>
</html>