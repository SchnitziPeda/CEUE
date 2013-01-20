<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java" 
	import="at.jku.ce.ue.source.clientLogic.impl.*"
	import="java.util.*" import="java.util.ListIterator"
	import="at.jku.ce.ue.bom.*"
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create your order</title>
<link rel="stylesheet" type="text/css" href="../bootstrap-responsive.css">
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
		<h1>CREATE ORDER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="../index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%		
		
// 			BOMServiceImpl bomService = new BOMServiceImpl();
// 			List<String> parts = bomService.getAllParts();

			SupplierClientServiceImpl supClient = new SupplierClientServiceImpl();
			List<String> parts = supClient.getAllPartNames();

// 			InquiryOrderPlattformServiceImpl inquiryOrder = new InquiryOrderPlattformServiceImpl();
// 			List<String> parts = inquiryOrder.getAllPartsOnPlattform();
			
			/*
			display further menu
			select producer
			show prices (supply chain)
			finally create and send order
			*/
		%>
		<div class="control-group">
		Your Customer-ID: <% out.println(request.getParameter("customerId")); %>
		</div>
		<br />
		<div class="control-group">
			<label class="control-label" for="inputName">Select your
				product: </label>
		</div>
		<div class="controls">
		<form name="supplyChainData" method="post" action="createOrder.jsp">
		<input type="hidden" name="customerId" value="<% out.println(request.getParameter("customerId")); %>">
		<%
			out.print("<select name='parts' onChange='this.form.submit()'>");
			for (String pd : parts) {
				out.print("<option value=" + pd.toString() + " on>"+ pd.toString() + "</option>");
			}
			out.print("</select>");
		%>
		</form>
		<%
		if(request.getParameter("parts")!=null && request.getParameter("customerId") != null){
			String partId = request.getParameter("parts");
			String customerId = request.getParameter("customerId");
			
			// TODO: direct sub parts have to be shown
// 			List<String> subParts = bomService.getDirectSubPartsOf(partId);
			
			SupplierClientServiceImpl supClientService = new SupplierClientServiceImpl();
			
			try{
	
				Map<String, Integer> supplyChains = supClientService.getSupplyChainForPart(partId, customerId);
				Iterator entries = supplyChains.entrySet().iterator();
				if(supplyChains.size()>0){
							
				%>
				Available supply chains: <% out.println(supplyChains.size()); %>
				<div class="control-group">
				Your have selected: <b><% out.println(partId); %></b>
				<br>
				Direct sub-parts of that:<br>
				<i>Show subparts here</i>
				</div>
				<div class="control-group">
				<form method="post" action="saveOrder.jsp" name="saveOrder">
				<input type="hidden" name="customerId" value="<% out.println(request.getParameter("customerId")); %>">
				<input type="hidden" name="partId" value="<% out.println(request.getParameter(partId)); %>">
				<table class="table">
					<tr>
						<td>Select chain</td><td>Producer</td><td>Price</td>
					</tr>
					<%
					// create supply chains here
					int i=0;
					while(entries.hasNext()){
						Map.Entry pairs = (Map.Entry)entries.next();
						out.println("<tr>");
						out.println("<td><input type='checkbox' name='order' value='order#"+i+"' class='controls'></td>");
						out.println("<td><input type='hidden' name='producer' value="+pairs.getKey()+"#"+i+">"+pairs.getKey()+"</td>");
						out.println("<td><input type='hidden' name='price' value="+pairs.getValue()+"#"+i+">"+pairs.getValue()+"</td>");
						out.println("</tr>");
						i++;
					}
 					%> 
				</table>
				<input type="submit" name="submit" value="save order" class="btn">
				</form>
				</div>
				<%
				} else	{
					out.println("Sorry, currently are no supply chains available.");
				}
			} catch(Exception e){
				out.println("Sorry, currently are no supply chains available.");
			}
		}
		
		%>
			
		</div>
	</div>
</body>

</html>