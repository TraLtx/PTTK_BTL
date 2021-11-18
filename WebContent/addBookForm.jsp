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
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<ul class="navbar-nav">
			</ul>
		</nav>
	</header>
	<center>
        <h1>Books Management</h1>
        <div class="container text-left">

				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">List of books</a>
		</div>
    </center>
    <div align="center">
        <c:if test="${bookItem != null}">
            <form action="updateBook" method="post">
        </c:if>
        <c:if test="${bookItem == null}">
            <form action="addBook" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${bookItem != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${bookItem == null}">
                        Add New Book
                    </c:if>
                </h2>
            </caption>
                <c:if test="${bookItem != null}">
                    <input type="hidden" name="id" value="<c:out value='${bookItem.id}' />" />
                </c:if>
                
             <!--//// Cac hang trong bang o day \\\\-->   
             <tr>
                <th>ISBN: </th>
                <td>
                    <input type="text" name="isbn" size="45"
                            value="<c:out value='${bookItem.book.isbn}' />"/>
                </td>
            </tr>
                       
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${bookItem.book.title}' />"/>
                </td>
            </tr>
                     
            <tr>
                <th>Summary: </th>
                <td>
                    <input type="text" name="summary" size="45"
                            value="<c:out value='${bookItem.book.summary}' />"/>
                </td>
            </tr>
                       
            <tr>
                <th>Publiccation Date: </th>
                <td>
                    <input type="text" name="publiccationDate" size="45"
                            value="<c:out value='${bookItem.book.publiccationDate}' />"/>
                </td>
            </tr>
                                   
            <tr>
                <th>Number of Page: </th>
                <td>
                    <input type="text" name="numPage" size="45"
                            value="<c:out value='${bookItem.book.numPage}' />"/>
                </td>
            </tr>
                                   
            <tr>
                <th>Language: </th>
                <td>
                    <input type="text" name="language" size="45"
                            value="<c:out value='${bookItem.book.language}' />"/>
                </td>
            </tr>
                                   
            <tr>
                <th>Size: </th>
                <td>
                    <input type="text" name="size" size="45"
                            value="<c:out value='${bookItem.book.size}' />"/>
                </td>
            </tr>
            <tr>
                <th>Appearance: </th>
                <td>
                    <input type="text" name="appearance" size="45"
                            value="<c:out value='${bookItem.book.appearance}' />"/>
                </td>
            </tr>
             
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${book.price}' />"/>
                </td>
            </tr>  
                           
            <tr>
                <th>Discount: </th>
                <td>
                    <input type="text" name="discount" size="45"
                            value="<c:out value='${book.discount}' />"/>
                </td>
            </tr>
           
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>
