<%@ page isELIgnored="false"%>
<%
String url = request.getContextPath();
request.setAttribute("Naaser", "naser");
request.setAttribute("url", url);
response.sendRedirect(url+"/second/signup");
%>
<html>
<body>
	
	<h2>Hello World!</h2>
	${request.getContextPath}
	${Naaser }
	${url }
	<%-- ${pageContext.request.ContextPath}--%>

</body>
</html>
