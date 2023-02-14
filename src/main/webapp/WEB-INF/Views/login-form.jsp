<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href='<c:url value="/second/static/css/mystyle.css" />'>
</head>
<body>
	<jsp:include page="navbar.jsp"/>
	<div class="contorller">
		<div class="row">
			<div class="offset-3 col-6 my-5">
					<h1 class="text-center">${heading }</h1>
				<form:form action="register" modelAttribute="student" cssClass="form-group" >
			
					<form:label path="email">Email:</form:label>
					<form:input path="email" class="form-control mb-2" type="email" placeholder="Enter your email" />

					<form:label path="password">Password:</form:label>
					<form:password path="password" class="form-control mb-2" placeholder="Enter your password" />
					
					<form:button name="Submit" value="Submit" class="btn btn-primary">Login</form:button>
					
				</form:form>
				<a href="#" class="btn btn warning">Froget Password</a>
				
			</div>
		</div>
	</div>
</body>
</html>