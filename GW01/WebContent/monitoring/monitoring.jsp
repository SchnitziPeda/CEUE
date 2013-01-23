<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="at.jku.ce.ue.source.Monitoring"
	import="java.sql.*"%>
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
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">

		<%
		String supplier = request.getParameter("inputName");
		Monitoring mon = new Monitoring();
		ResultSet rs = mon.getCalculatedOrders(supplier);
	%>
		Accumulated orders for Producer <b><% out.println(supplier);%>:</b>
		<br>
		<table class="table">
			<tr>
					<td><b>Customer</b></td>
					<td><b>Price</b></td>
				</tr>
			<tr>
				<%
					String output = "";
					while (rs.next()) {
						output += "<tr>";
						output += "<td>" + rs.getString("customerID") + "</td>";
						output += "<td>" + rs.getString("price") + "</td>";
						output += "</tr>";
					}
					out.print(output);
					mon.closeConnection();
				%>
			</tr>
		</table>
	</div>
</body>
</html>