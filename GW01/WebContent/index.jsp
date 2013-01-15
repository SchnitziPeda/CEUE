<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java"
import="at.jku.ce.ue.source.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gruppe 1 Plattform</title>
</head>
<body>
<%
// Initialize all stuff:
Init initialize = new Init();

%>
<h2>Plattform Gruppe 2</h2>

<a href="Register.jsp">Register</a>
<br>
<a href="ProdPartListing.jsp">List of all Producers and their parts on this platform</a>
<br>
<a href="Order.jsp">Orders</a>
<br>
<a href="Offer.jsp">Offers</a>
<br> 
<a href="checkOffers.jsp">check Offers - without concrete order possible</a>
<br> 
<a href="Monitoring.jsp">Monitoring</a>
</body>
</html>