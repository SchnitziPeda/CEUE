<%@page import="at.jku.ce.ue.source.clientLogic.impl.SupplierClientServiceImpl"%>
<%@page import="at.jku.ce.ue.source.businessLogic.SupplierService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
page language="java"
import="at.jku.ce.ue.source.*"
import="at.jku.ce.ue.source.entities.*"
import="at.jku.ce.ue.service.*"
import="at.jku.ce.ue.source.clientLogic.*"
import="java.util.Map"
import="java.util.*"
import="java.util.ListIterator"
import="at.jku.ce.ue.uddi.*"
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
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

				<!-- Be sure to leave the brand out there if you want it shown -->w
				<a class="brand" href="#">PLATFORM GW01 - CE UE WS 2012/2013</a>


				<!-- Everything you want hidden at 940px or less, place within here -->
				<div class="nav-collapse collapse">
					<!-- .nav, .navbar-search, .navbar-form, etc -->
				</div>
			</div>
		</div>
	</div>
	<div class="page-header">
		<h1>ORDER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<div>
			ToDo: Possibility to order some parts: <br> <br>
			<%
// 				SupplierService supplService = new SupplierClientServiceImpl();
				
// 				Map<String, Producer> prods = supplService.getAllProducers();
				
					//OrderParts availableParts = new OrderParts();
					// List<String> list = availableParts.testInqiury();
					// ListIterator iter1 = list.listIterator();

					// String plattformName = "gruppe4";
					// System.out.print(Init.getUddiReg().getWsdlOfPlattform(plattformName));
					// String plattformName = "gruppe 1 publisher";
					UddiInteraction uddiInter = new UddiInteraction();
// 					uddiInter.publishPlattformAndService();
// 					app.getListofEndpoints();
					uddiInter.deleteService();
					// uddiInter.publishPlattformAndService();
							
					// ListIterator iter1 = list.listIterator();
					// out.println("size: "+list.size());
					// System.out.print(uddiReg.publishPlattformAndService());

					// System.out.print(Init.getUddiReg().isRegistered(plattformName));
					// System.out.print(Init.getUddiReg().getWsdlOfPlattform(plattformName));
			%>
			<form name="selectedParts" method="post" action="Order.jsp">
				<%
// 					out.print("<select name='parts'>");
// 					for(Producer prod : prods.values()){
// 						out.print("<option value="+prod.getName()+">"+prod.getName()+"</option>");
// 					}
// 					out.print("</select>");
					
				%>
				<input type="submit" name="submit" value="Select">
			</form>
		</div>
</body>
</html>
