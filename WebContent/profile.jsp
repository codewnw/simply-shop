<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to SimplyShop</title>
</head>
<body>
	<%@ include file="/common/header.jsp" %>

	<h1>Hello, ${sessionScope.user.name}</h1>

	<%@ include file="/common/footer.jsp" %>
</body>
</html>