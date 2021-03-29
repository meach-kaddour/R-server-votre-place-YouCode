<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="<c:url value="/resources/min.css" />" rel="stylesheet">

    <title>Login Page</title>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<nav class="navbar navbar-light bg-light">
    <a class="navbar-brand" href="#">
        <!--<img src="../../resources/image/logo.png" width="30" height="30" alt="">-->
    </a>
    <h3 class="navbar-brand art-shadow ">Reserve Your Access</h3>

</nav>
            <div class='login-box'>
                <h1>Login here</h1>
                <!-- <div class="error"></div> -->
                <form action="Login" method="post">
                    <p>Email</p>
                    <input type="email" name="email" placeholder="Entrer Email">
                    <p>Password</p>

                    <input type="password" name="password" placeholder="Entrer password">
                    <input type="submit" name="submit" value="login">
                </form>

            </div>

</footer>
</body>
</html>
