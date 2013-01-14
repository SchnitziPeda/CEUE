<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java"
import="at.jku.ce.ue.source.Monitoring"
import="java.sql.*"

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ToDo: 
Possibility for a product manager to identify his top customers, save request to the database etc. 

<%
/**
Daten, die für's Monitoring (laut Skriptum) benötigt werden:
	Bei einer Anfrage:
		- eigene kunden ID
		- angefragte Sub-Lieferant (Lieferanten ID)
		- entspr. Teilebezeichnung
		- Anfragennummer (über Web-service Schnittstelle)
	Bei Angebotslegung:
		- Kunden ID
		- eigene Lieferanten ID
		- Anfragenummer
		- Angebotsnummer
		- Preis
	Bei Bestellung: 
		- Kunden ID
		- eigene Lieferanten ID
		- Anfragenummer
		- Angebotsnummer
		- Preis
		- Bestellnummer
*/
Monitoring mon = new Monitoring();
ResultSet rs = mon.getAllData();
out.println("<br><br>Showing 30 results:");
%>
<table border="1">
<tr>
	<td>CustomerID</td>
	<td>ProducerID</td>
	<td>PartID</td>
	<td>inquiryID</td>
	<td>OfferID</td>
	<td>Price</td>
	<td>Street</td>
	<td>User</td>
	<td>Datetime</td>
</tr>
<tr>
<%
String output = "";
while(rs.next()){
	output += "<tr>";
	output += "<td>"+rs.getString("customerID")+"</td>";
	output += "<td>"+rs.getString("producerID")+"</td>";
	output += "<td>"+rs.getString("partID")+"</td>";
	output += "<td>"+rs.getString("inquiryID")+"</td>";
	output += "<td>"+rs.getString("offerID")+"</td>";
	output += "<td>"+rs.getString("price")+"</td>";
	output += "<td>"+rs.getString("str")+"</td>";
	output += "<td>"+rs.getString("user")+"</td>";
	output += "<td>"+rs.getString("datetime")+"</td>";
	output += "</tr>";
}
out.print(output);
mon.closeConnection();
%>
</tr>
</table>


</body>
</html>