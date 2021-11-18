<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="logic_application.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
	<div align="center">
		<h1>Welcome to our Online Shop</h1>
	</div>
	
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">What do you want to buy?</h3>
			<hr>
			<div class="center">

				<a href="<%=request.getContextPath()%>/book" class="btn btn-success">Book</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/electronic" class="btn btn-success">Electronic</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/clother" class="btn btn-success">Clothes</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/shoe" class="btn btn-success">Shoe</a>
			</div>

		</div>
	</div>
</body>
</html>