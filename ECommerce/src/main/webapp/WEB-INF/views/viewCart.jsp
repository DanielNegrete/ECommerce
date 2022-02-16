<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> 
</head>
<body>
	<div class="container"><br>
	<div class="p-3 mb-2 bg-warning text-white rounded" align="center" ><h1>Products List</h1></div><br>
		<div class="d-flex justify-content-lg-start">
		<div class="table-responsive">
		<table class="table align-middle table-dark table-striped">
			<tr>
				<th class="align-middle">Product Name:</th>
				<th class="align-middle">Product Category:</th>
				<th class="align-middle">Price:</th>
				<th class="align-middle">Quantity:</th>
			</tr>
			<c:forEach items="${cartProducts}" var="cart">
				<tr>
					<td class="align-middle">${cart.productName}</td>
					<td class="align-middle">${cart.productCategory}</td>
					<td class="align-middle">$${cart.productPrice}</td>
					<td class="align-middle">${cart.productQuantity}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<div align="right">
				<br><P class="btn btn-outline-secondary disabled">Total price: $${total}</P><br>
		</div>
		<a class="btn btn-primary btn-lg" href="../buyCart/${userId}">Buy products</a>
	</div>
</body>
</html>