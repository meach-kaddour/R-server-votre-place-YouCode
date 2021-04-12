
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- Required Fremwork -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

<!-- Style.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/styleStudent.css"/>">
<title>Title</title>
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
							<li class="active"><a class="waves-effect waves-dark"
								href="loginDirect"> Logout </a></li>

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
												Welcome <span style="font-size: 32px;"><c:out
														value="${sessionScope.Fname}" /> <c:out
														value="${sessionScope.lasname}" /></span>
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


								<div class="page-wrapper">

									<div class="card">
										<div class="card-header">Add Reservation</div>
										<div class="card-body">
											<h5 class="card-title"></h5>

											<form:form modelAttribute="reservation"
												action="reserverAgain" method="post">

												<div class="form-group row">
													<label class="col-sm-2">Type of Reservation </label>
													<div class="col-sm-10">
														<form:select path="typeRes.id" cssClass="form-control">
															<c:forEach items="${ list }" var="elem">
																<form:option value="${elem.id}">${elem.typeRes}</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="line"></div>
												<br>


												<div class="form-group row">
													<label class="col-sm-2" for="date">Date</label>
													<div class="col-sm-10">
														<form:input path="dateRes" min="${datee}" type="date"
															onload="getDate()" class="form-control form-group" id="date"
															name="date" />
													</div>
												</div>




												<div class="line"></div>
												<br>
												<div class="form-group row">
													<div class="col-sm-4 offset-sm-2">
														<a href="dashbord"><button type="submit" id="annuler"
																class="btn btn-secondary mb-2">Cancel</button></a>
														<button type="submit" class="btn btn-primary mb-2">Reserver</button>
													</div>
													<!-- Page-body end -->
												</div>
												</form:form>
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

	<script>
		function getDate() {
			var today = new Date();

			document.getElementById("date").value = today.getFullYear() + '-'
					+ ('0' + (today.getMonth() + 1)).slice(-2) + '-'
					+ ('0' + today.getDate()).slice(-2);

		}
	</script>

	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/pcoded.min.js"/>"></script>
	<script src="<c:url value="/resources/js/vertical-layout.min.js"/>"></script>
	<script src="<c:url value="/resources/js/customdashboard.js"/>"></script>
	<script src="<c:url value="/resources/js/scripSTUDENT.js"/>"></script>

</body>
</html>
