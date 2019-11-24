<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to SimplyShop</title>
</head>
<body>
<%@ include file="/common/header.jsp"%>
	<div class="container">
		

		<form action="login" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp"
					placeholder="Enter email"> <small id="emailHelp"
					class="form-text text-muted">We'll never share your email
					with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" name="password" class="form-control"
					id="exampleInputPassword1" placeholder="Password">
			</div>
			<div class="form-group form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me
					out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


		</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>