<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
        <title>Home Page</title>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    </head>
    <body>
    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="#">
            <img src="${ pageContext.request.contextPath }/resources/image/logo.png" width="30" height="30" alt="">
        </a>
        <h3 class="navbar-brand art-shadow ">Reserve Your Access</h3>

        <a class="btn btn-primary" href="login">Login</a>
    </nav>
    <div class="row">
        <div class="col-4">
            <!--<h1 class="text-uppercase left-home mt-10 ">Reserver votre Accés Hors<br>Les horaires ds Etudes.</h1>-->
        </div>
        <div class="col-md-8">
            <!-- main -->
            <div class="main-w3layouts wrapper">
                <h1>Inscrivez-vous </h1>
                <div class="main-agileinfo">
                    <div class="agileits-top">
                        <form action="register" method="post">
                            <input class="text" type="text" name="prenom" placeholder="Prenom" required="">
                            <input class="text" type="text" name="nom" placeholder="Nom" required="">
                            <input class="text" type="text" name="class" placeholder="classe" required="">
                            <input class="text email" type="email" name="email" placeholder="Email" required="">
                            <input class="text w3lpass" type="password" name="password" placeholder="Password" required="">
                            <input type="submit" value="Regitre">
                            <p>Vous Avez un compte? <a href="login"> Login Now!</a></p>
                        </form>

                    </div>
                </div>

            </div>
            <!-- //main -->
        </div>
    </div>
    <footer>
        <!-- copyright -->
        <div class="colorlibcopy-agile">
            <p>© 2021 Youcode Access. All rights reserved | Design by <a href="http://kadorportfolio.epizy.com/" target="_blank">Kador</a></p>
        </div>
        <!-- //copyright -->
        <ul class="colorlib-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </footer>
    </body>
</html>
