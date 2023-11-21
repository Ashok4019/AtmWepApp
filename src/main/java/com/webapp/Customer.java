package com.webapp;

public class Customer {

	private String accnumber;
	private String pin;
	private String name;
	private long balance;

	
	public Customer(String accnumber, String pin, String name, long balance) {
		super();
		this.accnumber = accnumber;
		this.pin = pin;
		this.name = name;
		this.balance = balance;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAccnumber() {
		return accnumber;
	}


	public void setAccnumber(String accnumber) {
		this.accnumber = accnumber;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getBalance() {
		return balance;
	}


	public void setBalance(long balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Customer [accnumber=" + accnumber + ", pin=" + pin + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
