<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@
page language="java"
import="at.jku.ce.ue.source.*"
import="java.util.List"
import="java.util.ListIterator"
import="at.jku.ce.ue.uddi.*"

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
ToDo:
Possibility to order some parts:
<br>
<br>
<% 
if(request.getParameter("submit") != null){
	String part = request.getParameter("parts");
	out.print("You have selected the following part: "+part);
}

OrderParts availableParts = new OrderParts();
List<String> list = availableParts.testInqiury();
ListIterator iter1 = list.listIterator();

String plattformName = "gruppe4";
System.out.print(Init.getUddiReg().getWsdlOfPlattform(plattformName));



%>
<form name="selectedParts" method="post" action="Order.jsp">
<%
out.print("<select name='parts'>");
while(iter1.hasNext()){
	String text = iter1.next().toString();
	out.print("<option value="+text+">"+text+"</option>");
}
out.print("</select>");
%>
<input type="submit" name="submit" value="Select">
</form>
</body>
</html>