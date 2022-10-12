<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<style>
th{
	background-color: orange;
}
tr{
	background-color:yellow;
}
</style>
</head>
<body style = "background:white;">
<div align="center">
	<h3>
		<a href="enlist-company">Enlist a new company</a>
	</h3>
	<table border="1">
	  	<tr>
		    <th>Company Id</th>
		    <th>Company Name</th>
		    <th>Share Price</th>
		    <th>Actions</th>
	    </tr>
	    <c:forEach  items="${companyList}" var="company">
	      <tr>
		      <td>${company.companyId}</td>
		      <td>${company.companyName}</td>
		      <td>${company.sharePrice}</td>
		      <td>
			      <h3>
				      <a href = "edit-sharePrice/${company.companyId}">Edit</a>
				      <a href = "delete-company/${company.companyId}">Delete</a>
			      </h3>
		      </td>
	      </tr>
	     </c:forEach>
 		</table>
</div>
</body>
</html>