
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

long withAmount=Long.parseLong(request.getParameter("withdraw"));
String accnum=(String)session.getAttribute("accnum");

CustomerDAO dao=new CustomerDAO();
Customer customer=dao.getCustomer(accnum);
if(withAmount%100 !=0){
	
	out.println("please enter multiple of 100 only");
	request.getRequestDispatcher("withdraw.jsp").include(request, response);
}
else if(withAmount > customer.getBalance()){
	out.println("insufficent fund");
	request.getRequestDispatcher("withdraw.jsp").include(request, response);
}
	else{
		long newAmount=customer.getBalance()-withAmount;
		
		customer.setBalance(newAmount);
		dao.updateCustomer(customer);
		out.print("collect your mony"+ withAmount);
		out.print("Avilable blance"+ newAmount);
		
	}
	
%>

<%@
include file="continue.jsp"
%>
</body>
</html>