<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value="/resources/student.css" />" rel="stylesheet">
<link href="<c:url value="/resources/boot.css" />" rel="stylesheet">

<title>Student Page</title>
</head>
<body>
	<div class="container-fluid">


		<!--Start Navbar-->
		<nav class="navbar navbar-light bg-light"> <a
			class="navbar-brand" href="index"> <img
			src="${ pageContext.request.contextPath }/resources/image/logo.png"
			alt="logo_Youcode">
		</a>
		<h3 class="navbar-brand art-shadow  inline">Reserve Your Access</h3>

		</nav>
		<!--End Navbar-->
		<!--Start Main-->
		<div class="row">
			<!-- aside-area -->
			<div class="col-sm-2">
				<ul id="side-menu" class="nav">
					<li><a class="nav-link active" href="studentPage"><i
							class="fa fa-home" aria-hidden="true"></i>Add Reservation</a></li>
					<li><a class="nav-link" href="studentHistory"><i
							class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;Voir
							L'historique</a></li>
					<li><a class="nav-link" href="logout"><i
							class="fa fa-sign-out" aria-hidden="true"></i>&nbsp;&nbsp;Logout</a></li>
				</ul>
			</div>
			<!-- End aside area -->
			<!-- Main area -->
			<div class="col-sm-10">
				<br>
				<h2>Ajouter Nouveaux Reservation</h2>
				<hr>
				<br> <br>

				<div>

					<form action="addNewReservation" method="POST">
						<fieldset>
							<div class="form-group">
								<label><span class="fieldInfo">Type Reservation:</span></label>
								<!--<input type="te" class ="form-control" name="type" id="name"placeholder="chooses un type">-->
								<select class="form-control form-select"
									aria-label="Default select example" name="type">
									<option selected>chooses un type</option>
									<option value="1">week-end</option>
									<option value="2">hors day course</option>
									<option value="3">after course</option>
								</select>

							</div>

							<div class="form-group">
								<label for="Image"><span class="fieldInfo">Select
										Date </span></label> <input type="date" class="form-control" name="date"
									id="date" placeholder="Select date">
							</div>
							<br> <br> <input class="btn btn-success" type="submit"
								name="submit" value="Reserve">
						</fieldset>

					</form>
				</div>
				<br>

			</div>
			<!--End main area -->
		</div>
		<!--End  Main-->
		<footer class="row footer">
		<div class="col-md-12">
			<p class="text-dark">
				All <span>@CopyRight@ 2021</span> Reserved For Youcode
			</p>
		</div>
		</footer>
		<script>
			function SetMinDate() {
				var now = new Date();

				var day = ("0" + now.getDate()).slice(-2);
				var month = ("0" + (now.getMonth() + 1)).slice(-2);

				var today = now.getFullYear() + "-" + (month) + "-" + (day);

				document.getElementById("date").min = today;

			}
			SetMinDate();
		</script>
	</div>
</body>
</html>
