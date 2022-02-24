<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
		<div class="p-3 mb-2 bg-primary text-white rounded" ><h1>Registration</h1></div><br>
		<div class="d-flex justify-content-lg-start">
			<form:form action="saveUser" method="post" modelAttribute="user">
					<form:hidden path="userId"/>
						<span>Name:</span>
						<form:input class="form-control" path="name" /><br>
						<span>Password:</span>
						<form:input class="form-control" path="password" /><br>
						<span>Email:</span>
						<form:input class="form-control" path="emailId" /><br>
						<span>Phone Number:</span>
						<form:input class="form-control" path="phoneNo" /><br>
						<input class="btn btn-dark" type="submit" value="Register">

			</form:form>
		</div>
	</div>
</body>
</html>