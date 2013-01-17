<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="at.jku.ce.ue.source.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gruppe 1 Plattform</title>
<link rel="stylesheet" type="text/css" href="bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]> <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script> <![endif]-->
</head>
<body style>
	<div class="navbar navbar-inverse">
		<div class="navbar-inner">
			<div class="container">

				<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a>

				<!-- Be sure to leave the brand out there if you want it shown -->
				<a class="brand" href="#">PLATFORM GW01 - CE UE WS 2012/2013</a>

				<!-- Everything you want hidden at 940px or less, place within here -->
				<div class="nav-collapse collapse">
					<!-- .nav, .navbar-search, .navbar-form, etc -->
				</div>

			</div>
		</div>
	</div>
	<div class="page-header">
		<h1>HOME</h1>
	</div>

	<%
		// Initialize all stuff:
		Init initialize = new Init();
	%>
	<div class="moved-right">
		<ul class="nav nav-list">
			<li class="nav-header">Menu</li>
			<li><a href="Register.jsp">Register</a></li>
			<li><a href="AddProducts.jsp">Add products to a producer</a></li>
			<li><a href="ProdPartListing.jsp">Show all producers and
					parts on platform</a></li>
			<li><a href="Order.jsp">Orders</a></li>
			<li><a href="Offer.jsp">Offers</a></li>
			<li><a href="checkOffers.jsp">Check Offers - without
					concrete order possible</a></li>
			<li><a href="monitoring/index.jsp">Monitoring</a>
		</ul>
	</div>


	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="_/js/jquery.js"></script>
	<script src="_/js/bootstrap-transition.js"></script>
	<script src="_/js/bootstrap-alert.js"></script>
	<script src="_/js/bootstrap-modal.js"></script>
	<script src="_/js/bootstrap-dropdown.js"></script>
	<script src="_/js/bootstrap-scrollspy.js"></script>
	<script src="_/js/bootstrap-tab.js"></script>
	<script src="_/js/bootstrap-tooltip.js"></script>
	<script src="_/js/bootstrap-popover.js"></script>
	<script src="_/js/bootstrap-button.js"></script>
	<script src="_/js/bootstrap-collapse.js"></script>
	<script src="_/js/bootstrap-carousel.js"></script>
	<script src="_/js/bootstrap-typeahead.js"></script>
</body>
</html>
