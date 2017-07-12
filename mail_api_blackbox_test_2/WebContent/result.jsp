<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.mail.blackbox.util.ConstanceValue"%>
<%@page import="com.mail.blackbox.model.TestFault"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%
	HashSet<TestFault> result = (HashSet<TestFault>) request
			.getAttribute(ConstanceValue.OPTION_TEST_RESULT_VALUE);

	if (result != null) {
		int size = result.size();
		System.out.println(result.size());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>테스트결과</title>
</head>
<body>
	<center>
		<%
			Iterator<TestFault> it = result.iterator();
				while (it.hasNext()) {
		%>
		<%=it.next().toString()%><br>
		<%
			}
		%>

	</center>

</body>
</html>


<%
	}
%>