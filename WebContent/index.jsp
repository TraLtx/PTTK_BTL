<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<ul class="navbar-nav">
			</ul>
		</nav>
	</header>
	<br>

	<div style="float:left;width:600px;margin-left:60px;border: 3px solid #e8e8e8;border-radius: 12px;padding: 5px;">
			<p style="font-size:150%;text-align:center;"><b>Customer Login</b></p>
			
			<form action="<%=request.getContextPath()%>/loginresult" method="post">
				<div class="form-group">
				<label for="username">Username:</label>
				<input type="username" class="form-control" id="username" placeholder="Enter username" name="username">
				</div>

				<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
				</div>
						
				<input type="submit" value="Submit" />		
				<!-- <input type="button" onclick="alert('Done!')" value="Submit"> -->
			</form>
				
				
			<br>
			<br>
			<a href="<%=request.getContextPath()%>/register" class="btn btn-success">Register</a>
			<br>
			<br>
			<a href="<%=request.getContextPath()%>/adminLogin" class="btn btn-success">I am Admin</a>
			
		</div>
</body>
</html>