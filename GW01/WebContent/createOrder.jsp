<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

if(request.getParameter("submit")!=null){
	// add order to database
	
} else {
	/*
	Anzeige produkt
	
	*/

	
%>
<form class="form-horizontal" name="orderData" method="post" action="createOrder">



<input type="submit" name="submit" value="Submit">
</form>

</body>
<%
}
%>
</html>