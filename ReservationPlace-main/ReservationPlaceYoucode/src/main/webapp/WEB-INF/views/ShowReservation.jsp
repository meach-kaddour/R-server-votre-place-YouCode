
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Link To css And Font  -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <!-- Style.css -->
    <link rel="stylesheet" href="<c:url value="/resources/css/styleStudent.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/dataTables.bootstrap.min.css"/>">

    <title>Title</title>
</head>
<body>

<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<nav class="navbar header-navbar pcoded-header">
				<div class="navbar-wrapper">
					<div class="navbar-logo">
						<a href="dashbordadmin"> <img
							src=<c:url value="/resources/images/logo.png"/>
							style="width: 50px; hieght: 30px;" alt="Login">

						</a>
					</div>

					<div class="navbar-container container-fluid">

						<ul class="nav-right">
							<li class="header-notification" style="margin-top: 1.5em;">

								<ul class="show-notification">
									<li>
										<h6>Notifications</h6> <label class="label label-danger">New</label>
									</li>
								</ul>
							<li class="user-profile header-notification"><a 
								class="waves-effect waves-light"> <span><c:out
											value="${sessionScope.Fname}" /> <c:out
											value="${sessionScope.lasname}" /></span> <i class="ti-angle-down"></i>
							</a>
								<ul class="show-notification profile-notification">

									<li class="waves-effect waves-light"><a href="loginDirect">
											<i class="ti-layout-sidebar-left"></i> Logout
									</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<nav class="pcoded-navbar">
						<br>
						<br><br>
						<br>
						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a href="dashbordadmin"
								class="waves-effect waves-dark"> <span class="pcoded-micon">
										<b>D</b>
								</span> <span class="pcoded-mtext" data-i18n="nav.dash.main">Dashboard</span>
									<span class="pcoded-mcaret"></span>
							</a></li>

						</ul>

						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a href="ShowRes"
								class="waves-effect waves-dark"> <span class="pcoded-micon"><b>FC</b></span>
									<span class="pcoded-mtext" data-i18n="nav.form-components.main">
										Reservations</span> <span class="pcoded-mcaret"></span>
							</a></li>

						</ul>

						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a href="TypeRes"
								class="waves-effect waves-dark"> <span class="pcoded-micon"><b>FC</b></span>
									<span class="pcoded-mtext" data-i18n="nav.form-components.main">
										Type de Reservation</span> <span class="pcoded-mcaret"></span>
							</a></li>

						</ul>
					</nav>

					<div class="pcoded-content">
						<!-- Page-header start -->
						<div class="page-header">
							<div class="page-block">
								<div class="row align-items-center">
									<div class="col-md-8">
										<div class="page-header-title" style="font-size: 24px;">
											<h5 class="m-b-10">Dashboard Admin</h5>
											<p class="m-b-0">Welcome to Youcode Reservation
												Application For Administration</p>
										</div>
									</div>

								</div>
							</div>
						</div>
                <!-- Main Section -->
                <div class="pcoded-inner-content">
                    <!-- Main-body start -->
                    <div class="main-body">
                        <div class="card">
                            <div class="card-header">
                                <h5>Les Reservations des Apperenants</h5>

                            </div>
                            <div class="card-block table-border-style">
                                <div class="table-responsive">

                                    <form action="ShowResByDate" method="post">
                                        <div class="form-group row">

                                            <div class="col-sm-10">
                                                <input path="dateRes" type="date" onload="getDate()" class="form-control" id="date" name="date"/>
                                            </div>
                                            <button type="submit" class="btn btn-primary mb-2">search by date</button>
                                        </div>

                                    </form>

                                    <table class="table table-striped table-bordered" style="width:100%">
                                        <thead>

                                        <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Gmail</th>
                                            <th>Reservation</th>
                                            <th>Reservation Date</th>
                                            <th>Statut</th>
                                            <th>Confirmation</th>
                                        </tr>

                                        </thead>
                                        <tbody>
                                        <c:forEach items="${res}"  var="res">
                                            <tr>
                                                <td>${ res.user.firstName }</td>
                                                <td>${ res.user.lastName}</td>
                                                <td>${ res.user.email}</td>
                                                <td>${ res.typeRes.typeRes}</td>
                                                <td>${ res.dateRes}</td>

                                                <c:choose>
                                                    <c:when test="${ res.confirmation==false}">
                                                        <td><span class="label label-danger">Not yet confirmed</span></td>
                                                    </c:when>
                                                    <c:when test="${ res.confirmation==true}">
                                                        <td><span class="label label-success">confirmed</span></td>
                                                    </c:when>

                                                </c:choose>
                                                <td>
                                                    <form action="confiRes" method="post">
                                                        <input type="hidden" value="${ res.id }" name="id">
                                                        <input type="submit" value="Confirm" class="btn btn-success mr-5">
                                                    </form>

                                                    <form action="deleteRes" method="post">
                                                        <input type="hidden" value="${ res.id }" name="id">
                                                        <input type="submit" value="Refuse" class="btn btn-danger">
                                                    </form>
                                                </td>


                                            </tr>

                                        </c:forEach>



                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- Page-body end -->
                    </div>
                    <div id="styleSelector"> </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>

<script>
    function getDate(){
        var today = new Date();

        document.getElementById("date").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);


    }
</script>


<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/pcoded.min.js"/>"></script>
<script src="<c:url value="/resources/js/vertical-layout.min.js"/>"></script>
<script src="<c:url value="/resources/js/customdashboard.js"/>"></script>
<script src="<c:url value="/resources/js/scripSTUDENT.js"/>"></script>

<script src="<c:url value="/resources/js/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
<script>

    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>
</body>
</html>
