<%@page import="com.mail.blackbox.util.ConstanceValue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%
String root = request.getContextPath();
response.sendRedirect(root + ConstanceValue.TEST_CONTROLLER);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Mail API Test Page</title>
</head>
<body>
<input type="button" name="startTest">
</body>
</html>