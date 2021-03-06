<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="at.jku.ce.ue.source.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gruppe 1 Platform</title>
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
	try{
		// Initialize all stuff:
		Init initialize = new Init();
	%>
	<div class="moved-right">
		<ul class="nav nav-list">
			<li class="nav-header">Menu</li>
			<li><a href="Register.jsp">Register as Supplier</a></li>
			<li><a href="Customer.jsp">Register as Customer</a></li>
			<li><a href="order/createOrder.jsp">Check Offers & Order</a></li>
			<li><a href="monitoring/index.jsp">Monitoring</a></li>
			<li><a href="ProdPartListing.jsp">Show all producers and parts on this platform</a></li>
			<li><a href="AddProducts.jsp">Add products to a producer</a></li>
<!-- 			<hr> -->
<!-- 			For testing:  -->
<!-- 			<li><a href="uddiHandling.jsp">Uddi Handling</a></li> -->

		</ul>
	</div>
	<%
	} catch (Exception e){
		%>
		<div class="moved-right">
		We're sorry, but currently are no services available.<br>
		Please try again later. 
		</div>
		<%
	}
	%>
</body>
</html>
