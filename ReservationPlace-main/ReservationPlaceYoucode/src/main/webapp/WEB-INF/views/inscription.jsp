<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Page D'inscription</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/inscriptionPage.css" />">
</head>
<body>


	<div id="login-box">
		<div class="left">
			<h1>Sign up</h1>
			<form:form method="post" modelAttribute="student"
				action="registerForm">
				<form:input path="firstName" type="text" name="fn" id="namef"
					placeholder="Your FirstName" />
				<form:input path="lastName" type="text" name="ln" id="name"
					placeholder="Your LastName" />

				<form:input path="email" type="text" name="email" id="email"
					pattern="[A-Za-z0-9._%+-]+@[student]+\.+[youcode]+\.+[a-z]{2,}$"
					title="enter your youcode email" placeholder="Your Email" />

				<form:input path="phone" type="text"
					pattern="[0]{1}[6-7]{1}[0-9]{8}" title="enter valid phone"
					placeholder="Your Phone" />
				<form:input path="password" type="password"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="pass" id="pass"
					title="enter UpperCase, LowerCase, Number/SpecialChar and min 8 Chars"
					placeholder="Password" />
				<input type="password" name="re_pass" id="re_pass"
					placeholder="Repeat your password" />


				<input type="submit" name="signup_submit" id="signup"
					class="form-submit" value="Register" />

			</form:form>

		</div>

		<div class="right">
			<span class="loginwith">Sign in with<br />social network
			</span>

			<button class="social-signin facebook">Sign in with facebook</button>
			<button class="social-signin twitter">Sign in with Twitter</button>
			<button class="social-signin google">Sign in with Google+</button>
		</div>
		<div class="or">OR</div>
	</div>

</body>
</html>
