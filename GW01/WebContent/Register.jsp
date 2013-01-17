<%@page
	import="at.jku.ce.ue.source.presentation.presenter.RegisterPresenter"%>
<%@page import="at.jku.ce.ue.source.presentation.view.RegisterView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
page language="java" import="java.io.*"
	import="javax.xml.parsers.DocumentBuilderFactory"
	import="javax.xml.parsers.DocumentBuilder"
	import="javax.xml.transform.Transformer"
	import="javax.xml.transform.TransformerFactory"
	import="javax.xml.transform.stream.StreamResult"
	import="javax.xml.transform.dom.DOMSource"
	import="org.w3c.dom.Document" import="org.w3c.dom.NodeList"
	import="org.w3c.dom.Node" import="org.w3c.dom.Element"
	import="at.jku.ce.ue.source.RegisterSupplier"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lieferantenregistrierung</title>
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
		<h1>REGISTRATION</h1>
	</div>
	<div class="centered">
		<ul class="pager">
			<li class="Home"><a href="index.jsp">&larr; Home</a></li>
		</ul>
	</div>
	<div class="moved-right">
		<%
			RegisterView registerPresenter = new RegisterPresenter();

			String producerName = request.getParameter("inputName");

			int respond = registerPresenter.registerProducer(producerName,
					password, adress);

			/**
			 Speicherung der Daten in ein XML File 
			 - ID anhand des letzten Eintrags hochzählen und somit automatisch bestimmen
			 - relevaten Daten für die Speicherung:  
			 x KundenNamen
			 x KundenID
			 x Teile, die angeboten werden
			 */

			/**
			 Form eingaben überprüfen
			 checken ob xml file leer
			 -> ja, 1 ist erste ID
			 -> nein, ID aus xml auslesen 
			 ID hochzählen
			
			 Daten + ID in xml schreiben
			 */

			// forward data to RegisterSupplier
			/*
			 if(request.getParameter("submit")!=null){
			 RegisterSupplier regSub = new RegisterSupplier();
			 regSub.doPost(request, response);
			 }
			 /*
			 if(request.getParameter("submit")!=null){
			 String part1 = request.getParameter("part1");
			 part1 = part1.trim();
			 String part2 = request.getParameter("part2");
			 part2 = part2.trim();
			 String part3 = request.getParameter("part3");
			 part3 = part3.trim();
			 String supplierName = request.getParameter("supplierName");
			 supplierName = supplierName.trim();
			 if((part1.length()!=0 || part2.length()!=0 || part3.length()!=0) && supplierName.length()!=0){

			 int curId=0;
			
			 //	InputStream xmlFile = getServletContext().getResourceAsStream("/WEB-INF/supplierData.xml");
			 String xmlFile = getServletContext().getRealPath("/WEB-INF/supplierData.xml");
			 DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			 DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
			 Document doc = dBuilder.parse(xmlFile);	
			 doc.getDocumentElement().normalize();
			
			 // get root element
			 Element rootElement = doc.getDocumentElement();
			
			 // get children
			 NodeList supplierList = rootElement.getChildNodes();

			 out.println("<table><tr><td>Lieferantenname</td><td>Angebotene Teile</td></tr>");
			
			 // add new data to xml file:
			 if(supplierList != null && supplierList.getLength() > 0){
			
			 // read current id: 
			 Node node=null;
			 for(int i=0;i<supplierList.getLength();i++){
			 node = supplierList.item(i);
			 }
			 if(node.getNodeType() == Node.ELEMENT_NODE){
			 Element e = (Element) node;
			 NodeList ndList = e.getElementsByTagName("id");
			 NodeList elementValues = ndList.item(0).getChildNodes();
			 curId = Integer.parseInt(elementValues.item(0).getNodeValue());
			 // raise ID one up:
			 curId = curId+1;
			 }
			
			 NodeList ndList = doc.getElementsByTagName("listOfSuppliers");
			 node=null;
			 for(int i=0;i<ndList.getLength();i++){
			 node = ndList.item(i);
			 }
			 Element e = (Element) node;
			
			 // create new element:
			 Element newId = doc.createElement("id");
			 newId.appendChild(doc.createTextNode(Integer.toString(curId)));
			
			 Element name = doc.createElement("name");
			 name.appendChild(doc.createTextNode(supplierName));
			
			 Element newSupplier = doc.createElement("supplier");
			 newSupplier.appendChild(newId);
			 newSupplier.appendChild(name);
			
			 // add parts
			 Element newParts = doc.createElement("parts");
			 if(part1.length()!=0){
			 Element newPart = doc.createElement("part");
			 newPart.appendChild(doc.createTextNode(part1));
			 newParts.appendChild(newPart);
			 }
			 if(part2.length()!=0){
			 Element newPart = doc.createElement("part");
			 newPart.appendChild(doc.createTextNode(part2));
			 newParts.appendChild(newPart);
			 }
			 if(part3.length()!=0){
			 Element newPart = doc.createElement("part");
			 newPart.appendChild(doc.createTextNode(part3));
			 newParts.appendChild(newPart);
			 }
			
			 newSupplier.appendChild(newParts);
			
			 // add to list of suppliers	
			 rootElement.appendChild(newSupplier);
			
			 DOMSource source = new DOMSource(doc);
			
			 // write everything to xml file: 
			 Transformer transformer = TransformerFactory.newInstance().newTransformer();
			 FileOutputStream fos = new FileOutputStream(xmlFile);
			 StreamResult result = new StreamResult(fos);
			 transformer.transform(source, result);
			 fos.flush();
			 fos.close();
			 }
			
			 // display data: 
			 if(supplierList != null && supplierList.getLength() > 0){
			 out.println("Daten hinzugefügt!<br>Gesamte Liste:<br>");
			 for(int i=0;i<supplierList.getLength();i++){
			 Node node = supplierList.item(i);
			 if(node.getNodeType() == Node.ELEMENT_NODE){			
			
			 Element e = (Element) node;
			 NodeList ndList = e.getElementsByTagName("name");
			 NodeList elementValues;
			 if(ndList.item(0).hasChildNodes()){
			 elementValues = ndList.item(0).getChildNodes();
			 out.println("<tr><td>"+elementValues.item(0).getNodeValue()+"</td>");					
			 } else {
			 out.println("<tr><td>No name specified!</td></tr>");
			 }
			
			 NodeList partList = e.getElementsByTagName("parts");
			 Node nd = partList.item(0);
			 Element ele = (Element) nd;
			 partList = ele.getElementsByTagName("part");
			 if(partList.item(0).hasChildNodes()){
			 for(int k=0;k<partList.getLength();k++){
			 out.println("<td>"+partList.item(k).getChildNodes().item(0).getNodeValue()+"</td>");	
			 }
			 out.println("</tr>");
			 } else {
			 out.println("<td>No parts given!</td></tr>");
			 }
			
			 }
			 }
			 } else {
			 out.println("<tr><td>no entries found!</td></td>");
			 } 
			 out.println("</table>");
			
			
			 } else { // error message for input data
			 out.println("Bitte Angaben vollständig ausfüllen!");
			 }
			 }
			 else {*/
		%>
		<form class="form-horizontal" name="supplierData" method="post"
			action="Register.jsp">
			<div class="control-group">
				<label class="control-label" for="inputName">Name of
					Supplier:</label>
				<div class="controls">
					<input type="text" id="inputName" placeholder="Name">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputParts">Offered Parts:</label>
				<div class="controls">
					<input type="text" id="inputPart" placeholder="Part1">
				</div>
				<div class="controls">
					<input type="text" id="inputPart" placeholder="Part2">
				</div>
				<div class="controls">
					<input type="text" id="inputPart" placeholder="Part3">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAdress">Adress:</label>
				<div class="controls">
					<input type="password" id="inputAdress" placeholder="Adress">
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox">
						I'm just a Client
					</label>
					<button type="submit" class="btn">Submit</button>
				</div>
			</div>
		</form>
		<%
			// }
		%>
	</div>

</body>
</html>