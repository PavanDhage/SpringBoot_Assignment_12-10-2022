<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
<form:form action="company" method="post" modelAttribute="companyRecord">
Company Share:<form:input type="text" path="sharePrice"/>
<br/><br/>
<button type="submit">submit</button>
</h2>
</form:form>
</div>
</body>
</html>