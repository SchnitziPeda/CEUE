<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page language="java"
import="at.jku.ce.ue.source.businessLogic.impl.*" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monitoring</title>
<link rel="stylesheet" type="text/css" href="../bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="../bootstrap.css">
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
		<h1>MONITORING</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="../index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
	<%
	if(request.getParameter("submit") != null){
		String supplier = request.getParameter("inputName");
		// auf den namen checken 
		SupplierServiceImpl supService = new SupplierServiceImpl();
		if(supService.authentificateSupplier(supplier)){
			response.sendRedirect("monitoring.jsp");
		} else {
			out.println("Sorry, es ist ein Supplier mit diesem Namen registriert!");
		}
		
		
	} else {
	%>
	<form name="authData" method="post" action="index.jsp">
	<div class="control-group">
		<label class="control-label" for="inputName">Please enter the name of your
			Supplier:</label>
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
	</div>
	<%
	}	
	%>

</body>
</html>