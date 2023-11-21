<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.webapp.Customer" %>
    
    <%@page import="com.webapp.CustomerDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String accnum=request.getParameter("accnum");
String Pin=request.getParameter("Pin");
long Balance=Long.parseLong(request.getParameter("Balance"));
String name=request.getParameter("Name");

CustomerDAO dao=new CustomerDAO();
dao.createCustomer(accnum, Pin, name, Balance);
%>
</body>
</html>