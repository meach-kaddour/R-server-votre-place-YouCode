<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<!-- Style.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/styleStudent.css"/>">
<title>dashbord||Student</title>
</head>
<body>
	<div id="pcoded" class="pcoded">
		<div class="pcoded-container navbar-wrapper">
			<nav class="navbar header-navbar pcoded-header">
				<div class="navbar-wrapper">
					<div class="navbar-logo">
						<a href="dashbordadmin"> <img
							src=<c:url value="/resources/images/logo.png"/>
							style="width: 50px; hieght: 30px;" alt="Login">

						</a>
					</div>

					<div class="navbar-container container-fluid"></div>
				</div>
			</nav>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">
					<nav class="pcoded-navbar">
						<br> <br>

						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a href="dashbord"
								class="waves-effect waves-dark"> Reservations </a></li>

						</ul>

						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a href="Reserver"
								class="waves-effect waves-dark"> Reserver </a></li>

						</ul>
						<ul class="pcoded-item pcoded-left-item">
							<li class="active"><a class="waves-effect waves-dark" href="loginDirect"> Logout </a></li>

						</ul>
					</nav>

					<div class="pcoded-content">
						<!-- Page-header start -->
						<div class="page-header">
							<div class="page-block">
								<div class="row align-items-center">
									<div class="col-md-8">
										<div class="page-header-title">
											<h5 class="m-b-10">Dashboard Apperenant</h5>
											<p class="m-b-0" style="font-size: 24px;">
												Welcome <span style="font-size: 32px;"><c:out value="${sessionScope.Fname}" />
													<c:out value="${sessionScope.lasname}" /></span>
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
						<!-- Page-header end -->
					<div class="pcoded-inner-content">
						<!-- Main-body start -->
						<div class="main-body">
							<div class="card">
								<div class="card-header">
									<h5>Your  Reservations </h5>
								</div>
								<div class="card-block table-border-style">

									<div class="table-responsive">

										<c:choose>
											<c:when test="${msg != null}">

												<div class="alert alert-primary alert-dismissible fade show">
													<strong><c:out value="${msg}" /></strong>
													<button type="button" class="close" data-dismiss="alert">&times;</button>
												</div>
											</c:when>
											<c:when test="${msg = null}">
												<span></span>
											</c:when>

										</c:choose>



                                    <table class="table table-striped table-bordered" style="width:100%">
											<thead>
												<tr>
													<th>Reservation date</th>
													<th>Type of Reservation</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${ reservations }" var="reservation">
													<tr>
														<td>${ reservation.dateRes }</td>
														<td>${ reservation.typeRes.typeRes }</td>
														<c:choose>
															<c:when test="${ reservation.confirmation==false}">
																<td><span class="label label-danger">Not yet
																		confirmed</span></td>
															</c:when>
															<c:when test="${ reservation.confirmation==true}">
																<td><span class="label label-success">confirmed</span></td>
															</c:when>

														</c:choose>

														<td>
															<form action="deleteRestudent" method="post">
																<input type="hidden" value="${ reservation.id }"
																	name="id"> <input type="submit" value="Delete"
																	class="btn btn-danger">
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
					</div>
				</div>
			</div>
		</div>

	</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/pcoded.min.js"/>"></script>
	<script src="<c:url value="/resources/js/vertical-layout.min.js"/>"></script>
	<script src="<c:url value="/resources/js/customdashboard.js"/>"></script>
	<script src="<c:url value="/resources/js/scripSTUDENT.js"/>"></script>
</body>
</html>
