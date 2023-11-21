package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO {

	  
	public void createCustomer(String accnumber,String pin,String name,long balance) throws ClassNotFoundException, SQLException {
		Connection con = getconnction();
		PreparedStatement pscreate = con.prepareStatement("insert into customers values(?,?,?,?)");
		pscreate.setString(1, accnumber);
		pscreate.setString(2, pin);
		pscreate.setString(3, name);
		pscreate.setLong(4,balance);
		int result = pscreate.executeUpdate();

		}
	
	
	
	public Customer getCustomer(String accnum) throws SQLException, ClassNotFoundException {

		Connection con = getconnction();
		Statement st = con.createStatement();
		ResultSet result = st.executeQuery("select * from  customers where Accnum=" + accnum);
		if (result.next()) {

			return new Customer(result.getString("Accnum"), result.getString("Pin"), result.getString("Name"),
					result.getLong("Balance"));
		}
		return null;

	}

	public void updateCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection con = getconnction();
		PreparedStatement psupdate = con.prepareStatement("update customers set Name=?,Pin=?,Balance=? where Accnum=?");
		psupdate.setString(1, customer.getName());
		psupdate.setString(2, customer.getPin());
		psupdate.setLong(3, customer.getBalance());
		psupdate.setString(4, customer.getAccnumber());
		psupdate.executeUpdate();

	};

	public Connection getconnction() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "ashok");
	}
	
	  public static void main(String[] args) throws ClassNotFoundException, SQLException { 
		  CustomerDAO obj = new CustomerDAO(); 
			/*
			 * Customer customer =obj.getCustomer("123456789");
			 * System.out.println(customer);
			 * 
			 * 
			 * customer.setBalance(6000); obj.updateCustomer(customer); Customer customer1 =
			 * obj.getCustomer("123456789"); System.out.println(customer1);
			 */
		  obj.createCustomer("987654321", "1234", "Ajith", 23000);
		
	  
	  
	  
	  
	  }
	 

}
