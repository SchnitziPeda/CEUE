<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="at.jku.ce.ue.client.*,at.jku.ce.ue.client.bom.*,javax.xml.namespace.QName"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Deploy:
http://140.78.73.87:8085/manager/
user uece
pwd  2012WSceue

	<%
Object meinPort = application.getAttribute("meinPort");
		if (meinPort == null) {
	        InquiryOrderPlattformServiceService ss = new InquiryOrderPlattformServiceService(InquiryOrderPlattformServiceService.WSDL_LOCATION, new QName("http://ue.ce.jku.at/", "InquiryOrderPlattformServiceService"));
	        InquiryOrderPlattformService port = ss.getInquiryOrderPlattformServicePort();  

			application.setAttribute("meinPort", port);
			meinPort = port;
		}
 
 %>
 <%=((InquiryOrderPlattformService)meinPort).getAllProducersOnPlattform()%>
</body>
</html>