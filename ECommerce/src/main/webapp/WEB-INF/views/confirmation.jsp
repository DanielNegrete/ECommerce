<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
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
	<div class="alert alert-success" role="alert">Order completed</div>
	<div class="p-3 mb-2 bg-success text-white rounded" ><h1>Your Orders</h1></div><br>
		<div class="d-flex justify-content-lg-start">
		<div class="table-responsive">
			<h3>Your order details</h3>
			<c:forEach items="${orderList}" var="ord">
			<table class="table align-middle table-dark table-striped">
				<tr>
					<th class="align-middle">Order ID</th>
					<th class="align-middle">User ID</th>
					<th class="align-middle">Date</th>
					<th class="align-middle">Total</th>
				</tr>
					<tr>
						<td class="align-middle">${ord.orderId}</td>
						<td class="align-middle">${ord.userId}</td>
						<td class="align-middle">${ord.dateTime}</td>
						<td class="align-middle">$${ord.total}</td>
					</tr>
			</table><br>			
			</c:forEach>
			<br><h3>Your products details</h3>
			<table class="table align-middle table-dark table-striped">
			<tr>
				<th class="align-middle">Order No.</th>
				<th class="align-middle">Product Name</th>
				<th class="align-middle">Price</th>
				<th class="align-middle">Quantity</th>
			</tr>
			<c:forEach items="${productCart}" var="prod">
				<tr>
					<td class="align-middle">${prod.orderId}</td>
					<td class="align-middle">${prod.productName}</td>
					<td class="align-middle">$${prod.productPrice}</td>
					<td class="align-middle">${prod.productQuantity}</td>
				</tr>
			</c:forEach>
			</table>	
		</div>
		</div>
		<a class="btn btn-outline-dark" href="../getProducts?userId=${userId}">Products List</a>
	</div>
</body>
</html>