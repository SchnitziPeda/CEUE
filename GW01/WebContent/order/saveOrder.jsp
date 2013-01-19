<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java"
import="at.jku.ce.ue.source.clientLogic.impl.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saving order</title>
<link rel="stylesheet" type="text/css"
	href="../bootstrap-responsive.css">
<link rel="stylesheet" type="text/css" href="../bootstrap.css">
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
		<h1>SAVE ORDER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="../index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
	
	// TODO: recieving more than one form parameter...
	
// 	out.println(request.getParameter("order"));
	
	String customerId = request.getParameter("customerId");
	String partId = request.getParameter("partId");
						
// 	String[] parts = request.getParameterValues("producer");
// 	for(int i=0;i<parts.length;i++){
// 		out.println(parts[i]);
// 	}
		
	if(request.getParameter("order")!=null){
		out.println("Your order will now be saved. Thanks for ordering!");
		
		if(request.getParameterValues("producer")!=null && request.getParameter("price") != null){
			out.println("we will save it now");
			
			String[] orders = request.getParameterValues("order");
		 	String[] producers = request.getParameterValues("producer");
			String[] prices = request.getParameterValues("price");

			
			SupplierClientServiceImpl supClient = new SupplierClientServiceImpl();
			supClient.saveOrders(customerId, partId, orders, producers, prices);
			
// 		 	for(int i=0;i<orders.length;i++){
// 	 			out.println(orders[i]); 
// 	 		}
		 	
// 		 	for(int i=0;i<prodcuers.length;i++){
// 	 			out.println(prodcuers[i]); 
// 	 		}
		 	
// 		 	for(int i=0;i<price.length;i++){
// 	 			out.println(price[i]); 
// 	 		}
			
		}
				
		
				
				
				
				
	} else {
		out.println("We're sorry, you didn't select any product.");
		out.println("You can go <a href='createOrder.jsp'>back</a> here.");
	}
	
	
	
	%>


	</div>

</body>
</html>