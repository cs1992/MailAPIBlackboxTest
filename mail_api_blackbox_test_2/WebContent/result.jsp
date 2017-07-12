<%@page import="com.mail.blackbox.util.ConstanceValue"%>
<%@page import="com.mail.blackbox.model.TestFault"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%
    List<TestFault> result = (List<TestFault>) request.getAttribute(ConstanceValue.OPTION_TEST_RESULT_VALUE);

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
		    for (int i = 0; i < size; i++) {
		%>
			<%=result.get(i).toString() %><br>
		<%
				}
		%>

	</center>

</body>
</html>


<%
    }
%>