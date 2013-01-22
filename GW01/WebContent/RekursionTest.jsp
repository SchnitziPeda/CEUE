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
<title>Test of recursion</title>
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
		<h1>RECURSIVE TEST</h1>
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
		%>
		<form class="form-horizontal" name="selectSupplychain" method="post"
			action="RekursionTest.jsp">
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
					<button type="submit" value="submit" class="btn">Submit</button>
				</div>
			</div>
		</form>
		<%
			if (request.getParameter("submit") != null
					&& request.getParameter("part") != null) {
				String partId = request.getParameter("part");

				BOMServiceUtil bomService = new BOMServiceUtilImpl();
				List<String> subParts = bomService.getAllDirectSubpartsOfPart(partId);

				SupplierClientServiceImpl supClientService = new SupplierClientServiceImpl();
				
				Map<String, Integer> supplyChains = supClientService
						.getOffersForPart(partId, customerId);
				Iterator entries = supplyChains.entrySet().iterator();
				while (entries.hasNext()) {
					Map.Entry pairs = (Map.Entry) entries.next();
				}
		%>

	</div>
</body>

</html>