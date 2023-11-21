package com.webapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accnum = req.getParameter("accnum");
		String pin = req.getParameter("pin");
		System.out.println(accnum);
		CustomerDAO dao=new CustomerDAO();
		
		Customer customer=null;
		try {
			 customer = dao.getCustomer(accnum);
			 System.out.println(customer);
			 System.out.println(customer.getName());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(customer!=null && customer.getPin().equals(pin)) {
			HttpSession session=req.getSession();
			session.setAttribute("accnum", accnum);
			session.setAttribute("name",customer.getName());
			 System.out.println("true");
			 System.out.println(customer.getName());
			resp.sendRedirect("welcome.jsp");
		}
		else {
			 System.out.println("false");
			resp.sendRedirect("error.jsp");
		}
		
	}

	
}
