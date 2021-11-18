<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Book List</title>
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
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Books</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newBook" class="btn btn-success">Add
					New Book</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ISBN</th>
						<th>Title</th>
						<th>Summary</th>
						<th>Publiccation Date</th>
						<th>Number of Page</th>
						<th>Language</th>
						<th>Size</th>
						<th>Appearance</th>
						<th>Price</th>
						<th>Discount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="bookItem" items="${listBookItem}">

						<tr>
							<td><c:out value="${bookItem.book.isbn}" /></td>
                    		<td><c:out value="${bookItem.book.title}" /></td>
                    		<td><c:out value="${bookItem.book.summary}" /></td>
                    		<td><c:out value="${bookItem.book.publiccationDate}" /></td>
                    		<td><c:out value="${bookItem.book.numPage}" /></td>
                    		<td><c:out value="${bookItem.book.language}" /></td>
                    		<td><c:out value="${bookItem.book.size}" /></td>
                    		<td><c:out value="${bookItem.book.appearance}" /></td>
                    		<td><c:out value="${bookItem.price}" /></td>
                    		<td><c:out value="${bookItem.discount}" /></td>
							<td> 
								<a href="<%=request.getContextPath()%>/edit?id=<c:out value='${book.id}' />">Edit</a>
                        		&nbsp;&nbsp;&nbsp;&nbsp;
                        		<a href="<%=request.getContextPath()%>/delete?id=<c:out value='${book.id}' />">Delete</a>  
                       		</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
