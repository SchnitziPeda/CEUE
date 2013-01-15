<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="at.jku.ce.ue.client.*" import="at.jku.ce.ue.client.bom.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Georg</title>
</head>
<body>
	<br /> http://localhost:8085/GWTutorial/
	<hr />
	<br /> Georg sagt hallo
	<br />
	<%
		/* application Context/Scope */
		Object meinTest = application.getAttribute("meinTest");
		if (meinTest == null) {
			StringBuilder test = new StringBuilder();
			application.setAttribute("meinTest", test);
			meinTest = test;
		}
		StringBuilder strTest = (StringBuilder) meinTest;
		for (int i = 0; i < 2; ++i) {
			strTest.append('a');
		}
		out.append("out: ");
		out.append(strTest.toString());
		out.append("<br/>");

		/* Session Context/Scope */
		Object meinTestSession = session.getAttribute("meinTest");
		if (meinTestSession == null) {
			StringBuilder testSession = new StringBuilder();
			session.setAttribute("meinTest", testSession);
			meinTestSession = testSession;
		}
		StringBuilder strTestSession = (StringBuilder) meinTestSession;
		for (int i = 0; i < 2; ++i) {
			strTestSession.append('a');
		}
		out.append("out sesssion: ");
		out.append(strTestSession.toString());
		out.append("<br/>");
	%>
	
	direkt in HTML<br/>
	<%=strTest %>
	<br/><br/>
	session direkt in HTML<br/>
	<%=strTestSession %>
</body>
</html>