<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register</title>
	</head>
	<body>
		<h1>
			Login Failure
		</h1>
		<p>
			<% out.print((String) request.getAttribute("message")); %>
		</p>
		<a href="login">
			Login
		</a>
		<br/>
		<a href="home">
			Home
		</a>
	</body>
</html>