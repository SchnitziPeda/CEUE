<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java" import="at.jku.ce.ue.source.clientLogic.impl.*"
	import="java.util.*" import="java.util.ListIterator"
	import="at.jku.ce.ue.bom.*"
	import="at.jku.ce.ue.source.businessLogic.impl.*"
	import="at.jku.ce.ue.source.businessLogic.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check offers and order</title>
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
		<h1>CHECK OFFERS & ORDER</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="../index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
			SupplierClientServiceImpl supClient = new SupplierClientServiceImpl();
			List<String> parts = supClient.getAllPartNames();
			List<String> customers = supClient.getAllCustomerNames();

			/*
			display further menu
			select producer
			show prices (supply chain)
			finally create and send order
			 */
		%>
		<form class="form-horizontal" name="selectSupplychain" method="post"
			action="createOrder.jsp">
			<div class="control-group">
				<label class="control-label" for="customers">ID of Customer:</label>
				<div class="controls">
					<%
						out.print("<select name='customer'>");
						for (String c : customers) {
							out.print("<option value=" + c + ">" + c + "</option>");
						}
						out.print("</select>");
					%>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="part">Part</label>
				<div class="controls">
					<%
						out.print("<select name='part'>");
						for (String pd : parts) {
							out.print("<option value=" + pd.toString() + " on>"
									+ pd.toString() + "</option>");
						}
						out.print("</select>");
					%>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
		</form>

		<%
			if (request.getParameter("part") != null
					&& request.getParameter("customer") != null) {
				
				// TODO: create offer id to save to database 
				
				String partName = request.getParameter("part");
				String customerId = request.getParameter("customer");

				BOMServiceUtil bomService = new BOMServiceUtilImpl();
				List<String> subParts = bomService
						.getAllDirectSubpartsOfPart(partName);

				SupplierClientServiceImpl supClientService = new SupplierClientServiceImpl();

				try {

					Map<String, Integer> supplyChains = supClientService
							.getOffersForPart(partName, customerId);
					Iterator entries = supplyChains.entrySet().iterator();
					if (supplyChains.size() > 0) {
		%>
		<div class="control-group">
			<%
				if(subParts.size() > 0){
					out.println("Your selected part<b> "+partName+"</b> contains the following subparts:");
					out.println("<ul>");
					for(String s : subParts){
						out.println("<li>"+s+"</li>");
					}
					out.println("</ul>");
				} else{
					out.println("No further sub-parts available!");
				} 
					
 			%>
		</div>
		<div class="control-group">
			<form method="post" action="saveOrder.jsp" name="saveOrder">
				<input type="hidden" name="customerId"
					value="<%out.println(customerId);%>"> <input type="hidden"
					name="partId" value="<%out.println(partName);%>">
				<table class="table">
					<tr>
						<td><b>Select chain:</b></td>
						<td><b>Producer</b></td>
						<td><b>Price</b></td>
					</tr>
					<%
						// create supply chains here
									int i = 0;
									while (entries.hasNext()) {
										Map.Entry pairs = (Map.Entry) entries.next();
										out.println("<tr>");
										out.println("<td><input type='checkbox' name='order' value='order#"
												+ i + "' class='controls'></td>");
										out.println("<td><input type='hidden' name='producer' value="
												+ pairs.getKey()
												+ "#"
												+ i
												+ ">"
												+ pairs.getKey() + "</td>");
										out.println("<td><input type='hidden' name='price' value="
												+ pairs.getValue()
												+ "#"
												+ i
												+ ">"
												+ pairs.getValue() + "</td>");
										out.println("</tr>");
										i++;
									}
					%>
				</table>
				<input type="submit" name="submit" value="Save Order" class="btn">
			</form>
		</div>
		<%
			} else {
						out.println("Sorry, currently are no supply chains available.");
					}
				} catch (Exception e) {
					out.println("Sorry, currently are no supply chains available.");
				}
			}
		%>

	</div>
	</div>
	</div>
</body>

</html>