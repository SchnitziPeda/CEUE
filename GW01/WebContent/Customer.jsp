<%@page
	import="at.jku.ce.ue.source.presentation.presenter.RegisterPresenter"
%>
<%@page import="at.jku.ce.ue.source.presentation.view.RegisterView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Customer</title>
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
		<h1>CUSTOMER REGISTRATION</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
		if(request.getParameter("submit") != null){
			RegisterView registerPresenter = new RegisterPresenter();

			String customerName = request.getParameter("inputName");

			String resp = registerPresenter.registerCustomer(customerName);

			if (!resp.equals("-1")) {
				out.println("Thank you for your registration.<br>");
				out.println("You're registered with the following name: "+customerName);
				
			} else {
				out.println("Your registration did not work. <br> We are sorry, it seems you're already registered.<br>");
				out.println("You still can go <a href='Customer.jsp'>back</a> and try again.");
			}

		} else {

		%>
		<form class="form-horizontal" name="customerData" method="post"
			action="Customer.jsp">
			<div class="control-group">
				<label class="control-label" for="inputName">Name of
					Customer:</label>
				<div class="controls">
					<input type="text" name="inputName" placeholder="Name">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" name="submit" class="btn">Submit</button>
				</div>
			</div>
		</form>
		<%
		}
		%>
	</div>

</body>
</html>