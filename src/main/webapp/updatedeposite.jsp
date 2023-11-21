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

long depositAmound=Long.parseLong(request.getParameter("deposite"));
String accnum =(String)session.getAttribute("accnum");

CustomerDAO dao=new CustomerDAO();
Customer customer=dao.getCustomer(accnum);

long newAmound=customer.getBalance()+depositAmound;

customer.setBalance(newAmound);
dao.updateCustomer(customer);
out.print("Avilable blance"+ newAmound );

%>
<%@
include file="continue.jsp"
%>
</body>
</html>