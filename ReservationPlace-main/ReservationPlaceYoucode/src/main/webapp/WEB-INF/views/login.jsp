<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>login</title>
<!-- Style -->
<link rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"
	type="text/css">

</head>
<body>



	<div class='login-box'>
		<h1>Login here</h1>
		<img src=<c:url value="/resources/images/logo.png"/> alt="Login">
		 <span><c:out value="${msg}" /></span>
		<form:form method="post" modelAttribute="userlogin"
			action="Login">
			<p>Email</p>

			<form:input path="email" type="email" class="form-control"
				id="username" name="username" />


			<p>Password</p>

			<form:input path="password" type="password" class="form-control"
				id="password" name="password" />

			<input type="submit" name="submit" value="login">


		</form:form>
		<div class="m-5 align-items-center">
			<span class="caption"><a href="registre" >Create
					an account</a></span>
		</div>
	</div>


</body>
</html>
