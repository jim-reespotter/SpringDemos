<html>
<body>
<h2>content page</h2>

Name: ${name}
<br/>
Creds: ${creds}
<br/>
Details: ${details}
<br/>


<form action="<%=request.getContextPath()%>/logout" method="POST">
	<input type="text" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" value="Logout"/>
</form>

</body>
</html>

