<%@page import="org.springframework.ui.Model"%>
<%@page import="com.spring.models.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/second/static/css/mystyle.css" />'>
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<div class="contorller">
		<div class="row">
			<div class="offset-3 col-5 my-5">
				<%-- <h1 class="text-center">${msg }</h1>
				<img src='<c:url value="/second/static/images/${student.profile}" />' alt="Image Not Found">
				<h2>${student.name }</h2>
				<h2>${student.email }</h2>
				<h2>${student.password }</h2>
				<fmt:parseDate var="studentDate" value="${student.dob}"
					pattern="yyyy-MM-dd" />
				<h2>
					<fmt:formatDate type="date" value="${studentDate}" />
				</h2>
				<c:if test="${student.gender=='M' }">
					<h2>Male</h2>
				</c:if>
				<c:if test="${student.gender =='F' }">
					<h2>Female</h2>
				</c:if>
				<c:forEach var="hobby" items="${student.hobbies}">
					<h2 style="display: inline">${hobby}
						<c:choose>
							<c:when test="${student.hobbies!=null}">
								<c:out value=", "></c:out>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</h2>
				</c:forEach>
				<h2>${student.country }</h2>
			<a href="update/${student.id }" class="btn btn-warning">Update</a> --%>

				<div class="modal-body">
					<div class="text-center">
						<img
							src='<c:url value="/second/static/images/${student.profile}" />'
							class="img-fluid" style="border-radius: 50%; max-width: 180px;">
					</div>
					<h4 class="text-center mt-2">${student.name.firstName} ${student.name.lastName }</h4>
					<div id="user-details">
						<table class="table">
							<tr>
								<th scope="row">ID</th>
								<td>${student.id }</td>
							</tr>
							<tr>
								<th scope="row">Name</th>
								<td>${student.name.firstName} ${student.name.lastName }</td>
							</tr>
							<tr>
								<th scope="row">Email</th>
								<td>${student.email }</td>

							</tr>
							<tr>
								<fmt:parseDate var="studentDate" value="${student.dob}"
									pattern="yyyy-MM-dd" />
								<th scope="row">Date of join</th>
								<td><fmt:formatDate type="date" value="${studentDate}" /></td>
							</tr>
							<tr>
								<th scope="row">Password</th>
								<td>${student.password }</td>
							</tr>
							<tr>
								<th scope="row">Gender</th>
								<c:if test="${student.gender=='M' }">
									<td>Male</td>
								</c:if>
								<c:if test="${student.gender=='F' }">
									<td>Female</td>
								</c:if>
							</tr>
							<tr>
								<th scope="row">Hobbies</th>
								<td><c:forEach var="hobby" items="${student.hobbies}">
									${hobby}	
								</c:forEach></td>
							</tr>

						</table>
					</div>
				</div>
			</div>
		</div>
</body>
</html>