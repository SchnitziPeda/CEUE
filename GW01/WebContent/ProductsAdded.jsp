<%@page
	import="at.jku.ce.ue.source.presentation.presenter.RegisterPresenter"%>
<%@page import="at.jku.ce.ue.source.presentation.view.RegisterView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
page language="java" import="java.io.*" import="java.util.List"
	import="java.util.LinkedList"
	import="at.jku.ce.ue.source.entities.*"
	import="at.jku.ce.ue.source.presentation.presenter.*"
	import="at.jku.ce.ue.source.presentation.view.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
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
		<h1>ADD PRODUCTS</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
		List<String> addedProductsList = (List<String>)application.getAttribute("addedProductsList");
						String producerID = (String)application.getAttribute("producerID");
			int price;
			boolean success=false;
			for (String p : addedProductsList) {
				price = Integer.parseInt(request.getParameter(p));
				
				Producer prod = Database.getInstance().getProducer(producerID);
				
				prod.getParts().put(p, price);
				
				if (prod.getParts().containsKey(p)) {
					success = true;
// 					out.println(p + " was added!<br>");
				} else {
					success = false;
// 					out.println(p + " was not added!");
				}
			}
			if(success){
				out.println("Everything has been successfully been added.<br>");
				out.println("You can go <a href='index.jsp'>back</a> now.");
			} else {
				out.println("We're sorry, an error occured.<br> Please try again.");
				out.println("You can go <a href='index.jsp'>back</a> now.");
			}
		%>

	</div>

</body>
</html>