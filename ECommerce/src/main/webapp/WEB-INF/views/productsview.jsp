<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
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
		<a>Search: <input id="searchTerm" type="text" onkeyup="doSearch()"  class="form-control" /></a><br>
		<table class="table align-middle table-dark table-striped" id="regTable">
			<tr>
				<th class="align-middle">Product Name:</th>
				<th class="align-middle">Product Category:</th>
				<th class="align-middle">Price:</th>
				<th class="align-middle">Available Quantity:</th>
				<th class="align-middle"></th>
			</tr>
			<c:forEach items="${productsList}" var="prod">
				<tr>
					<form:form action="addCartProduct" method="post" modelAttribute="product">
					<td class="align-middle">${prod.productName}</td>
					<td class="align-middle">${prod.productCategory}</td>
					<td class="align-middle">$${prod.productPrice}</td>
					<td class="align-middle">${prod.productQuantity}</td>
					
					<input path="userId" type = "hidden" name="userId" value = "${userId}">
					<input path="producId" type = "hidden" name="productId" value = "${prod.productId}">
					<input path="productName" type = "hidden" name="productName" value = "${prod.productName}">
					<input path="productCategory" type = "hidden" name="productCategory" value = "${prod.productCategory}">
					<input path="productPrice" type = "hidden" name="productPrice" value = "${prod.productPrice}">
					<input path="productQuantity" type = "hidden" name="productQuantity" value = "${prod.productQuantity}">
					<td class="align-middle"><input class="btn btn-outline-light" type="submit" value="add to cart"></td>
					</form:form>
				</tr>
			</c:forEach>
		</table>
		</div>
		</div>
		<a class="btn btn-outline-dark" href="viewCart/${userId}">View Cart</a>
	</div>
	        <script>
            function doSearch() {
                var tableReg = document.getElementById('regTable');
                var searchText = document.getElementById('searchTerm').value.toLowerCase();
                for (var i = 1; i < tableReg.rows.length; i++) {
                    var cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
                    var found = false;
                    for (var j = 0; j < cellsOfRow.length && !found; j++) {
                        var compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                        if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1)) {
                            found = true;
                        }
                    }
                    if (found) {
                        tableReg.rows[i].style.display = '';
                    } else {
                        tableReg.rows[i].style.display = 'none';
                    }
                }
            }
        </script>
</body>
</html>