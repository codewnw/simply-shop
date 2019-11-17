<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to SimplyShop</title>
</head>
<body>
<jsp:include page="/common/header.jsp" />
<a href="${pageContext.request.contextPath}/user/registration.jsp">Register</a>
<jsp:include page="/common/footer.jsp" />
</body>
</html>