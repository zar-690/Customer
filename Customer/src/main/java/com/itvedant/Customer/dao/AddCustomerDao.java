package com.itvedant.Customer.dao;

public class AddCustomerDao {
	
	private String customerName;
	private Integer salary;
	private String email;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AddCustomerDao [customerName=" + customerName + ", salary=" + salary + ", email=" + email + "]";
	}
}
