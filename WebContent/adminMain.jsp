<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
		<h1>Online Shop Manager</h1>
	</div>
	
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Manager Item</h3>
			<hr>
			<div class="center">

				<a href="<%=request.getContextPath()%>/AdminBook" class="btn btn-success">Book</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/AdminElectronic" class="btn btn-success">Electronic</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/AdminClother" class="btn btn-success">Clothes</a>
				<br>
				<br>
				<a href="<%=request.getContextPath()%>/AdminShoe" class="btn btn-success">Shoe</a>
			</div>

		</div>
	</div>
</body>
</html>