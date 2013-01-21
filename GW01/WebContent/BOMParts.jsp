<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@
page language="java" import="java.io.*"
	
	import="at.jku.ce.ue.source.*" import="at.jku.ce.ue.source.entities.*"
	import="at.jku.ce.ue.service.*"
	import="at.jku.ce.ue.source.businessLogic.impl.*"
	import="java.util.List" import="java.util.ListIterator"
	import="at.jku.ce.ue.uddi.*"
	import="at.jku.ce.ue.source.businessLogic.*"
	import="org.w3c.dom.Document" import="org.w3c.dom.NodeList"
	import="org.w3c.dom.Node" import="org.w3c.dom.Element"
	import="at.jku.ce.ue.source.RegisterSupplier"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		<h1>OFFER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%

		PartService partService = new PartServiceImpl();
		List<Part> partsList = partService.getAllParts();
		
		out.println("<table>");
		for(Part part :partsList){
			out.println("<tr>");
			out.println("<td>");
			out.println(part.getName());
			out.println("</td>");
			for(Part subPart : part.getSubParts()){
				out.println("<tr>");
				out.println("<td>");
				out.println("</td>");
				out.println("<td>");
				out.println(subPart.getName());
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		
		%>
	</div>


</body>
</html>
