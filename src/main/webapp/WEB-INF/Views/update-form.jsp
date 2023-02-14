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
					<h1 class="text-center">Update Form</h1>
				<form:form action="${pageContext.request.contextPath }/second/updatehandler"  method="post" modelAttribute="student" cssClass="form-group" >
				
					<form:input type ="hidden" path="id" class="form-control mb-2" placeholder="Enter your password" />
					
					<form:label path="name" >Name:</form:label>
					<form:input path="name" class="form-control mb-2" placeholder="Enter your name" />

					<form:label path="email">Email:</form:label>
					<form:input path="email" class="form-control mb-2" type="email" placeholder="Enter your email" />
					
					<form:input type ="hidden" path="password" class="form-control mb-2" placeholder="Enter your password" />
					
					<form:label path="dob">Date of Birth:</form:label>
					<form:input path="dob" type = "date" cssClass="form-control mb-2" placeholder= "Select date of birth"/>
					
					<form:label path="gender">Gender</form:label>
					<form:radiobutton path="gender" cssClass="m-2"  value="M" label="Male" />
					<form:radiobutton path="gender" cssClass="m-2"  value="F" label="Female" />
					
					<br>
					
					<form:label path="hobbies">Hobbies:</form:label>
					<form:checkboxes items="${hobbies }" cssClass="m-2" path="hobbies" />
					
					<br>
					
					<form:label path="country">Country:</form:label>
					<form:select path="country" cssClass="form-control mb-2">
					<form:option value="india" label="India"/>
					<form:option value="united states" label="United States"/>
					<form:option value="england" label="England"/>
					<form:option value="australia" label="Australia"/>
					</form:select>
					
					<form:button name="Submit" value="Submit" class="btn btn-success">Update</form:button>
					
				</form:form>
				
			</div>
		</div>
	</div>
</body>
</html>