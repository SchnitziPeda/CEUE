<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java"
	import="at.jku.ce.ue.source.businessLogic.impl.*"
	import="at.jku.ce.ue.source.entities.*" import="java.util.List"
	import="java.util.Map" import="java.util.ListIterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producer/Part Listing</title>
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
		<h1>ALL PRODUCERS AND PARTS ON THIS PLATFORM</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<div>

			<ul>
				<%
					SupplierServiceImpl supplService = new SupplierServiceImpl();

					Map<String, Producer> prodList = supplService.getAllProducers();

					for (Producer prod : prodList.values()) {
						out.print("<li>");
						out.println("Producer: " + prod.getName());
						out.print("</li>");
						out.print("<ul>");
						Map<String, Integer> partsOfProd = prod.getParts();
						for (String part : partsOfProd.keySet()) {
							out.print("<li>");
							out.println(part);
							out.println("- Price: " + partsOfProd.get(part) + ",-");
							out.print("</li>");
						}
						out.print("</ul>");
					}
				%>
			</ul>
		</div>
	</div>

</body>
</html>
