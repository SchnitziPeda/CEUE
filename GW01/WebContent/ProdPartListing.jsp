<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page language="java"
	import="at.jku.ce.ue.source.businessLogic.impl.*"
	import="at.jku.ce.ue.source.entities.*" import="java.util.List"
	import="java.util.ListIterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Producer/Part Listing</title>
</head>
<body>
	Listing of all producers and platforms of this platform:<br/>
	<%
	SupplierServiceImpl supplService = new SupplierServiceImpl();

	List<Producer> prodList = supplService.getAllProducers();

	for (int i = 0; i < prodList.size(); i++) {
		Producer prod = prodList.get(i);
		out.println("Producer: " + prod.getName()+"<br />");
		List<Part> partsOfProd = prod.getParts();
		for(Part part : partsOfProd){
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+part.getName()+"<br />");
		}
	}
%>
</body>
</html>
