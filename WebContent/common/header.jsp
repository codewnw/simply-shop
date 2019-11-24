<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
		</li>
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
			aria-expanded="false"> Welcome,&nbsp; ${sessionScope.user eq null ? ' Guest':  sessionScope.user.name}

		</a> <c:if test="${sessionScope.user ne null}">
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="${pageContext.request.contextPath}/user/registration.jsp">Edit Profile</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="logout">Logout</a>
				</div>
			</c:if>
			
			<c:if test="${sessionScope.user eq null}">
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="#">Something else here</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/login">Signin</a>
					<a class="dropdown-item" href="${pageContext.request.contextPath}/user/registration.jsp">Signup</a>
				</div>
			</c:if>
			
			</li>
		<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#"
			tabindex="-1" aria-disabled="true">Disabled</a></li>
	</ul>
</body>
</html>