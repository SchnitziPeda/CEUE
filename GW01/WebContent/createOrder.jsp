<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java" import="at.jku.ce.ue.client.*"
	import="java.util.*" import="java.util.ListIterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create your order</title>
<link rel="stylesheet" type="text/css" href="bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
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
		<h1>CREATE ORDER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
		/**
		IDEE: im hintergrund alle daten generieren, danach mit collapse events die entsprechenden datenfelder anzeigen!
		*/
		
		
			if(request.getParameter("parts")!=null){
				out.println("show all producers for "+request.getParameter("parts"));
			}
		
		
			InquiryOrderPlattformServiceImpl inquiryOrder = new InquiryOrderPlattformServiceImpl();
			List<String> parts = inquiryOrder.getAllPartsOnPlattform();
			
			/*
			display further menu
			select producer
			show prices (supply chain)
			finally create and send order
			*/
		%>
		<div class="control-group">
			<label class="control-label" for="inputName">Select your
				product: </label>
		</div>
		<div class="controls">
		<form name="supplyChainData" method="post" action="createOrder.jsp">
		<%
			out.print("<select name='parts' onChange='this.form.submit()'>");
			for (String pd : parts) {
				out.print("<option value=" + pd.toString() + " on>"+ pd.toString() + "</option>");
			}
			out.print("</select>");
		%>
		</form>
		</div>
	</div>
</body>

</html>