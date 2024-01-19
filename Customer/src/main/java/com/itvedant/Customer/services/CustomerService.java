 package com.itvedant.Customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itvedant.Customer.dao.AddCustomerDao;
import com.itvedant.Customer.dao.UpdateCustomerDao;
import com.itvedant.Customer.entities.Customer;
import com.itvedant.Customer.repo.CustomerRepository;





@Service
public class CustomerService {

	private static final String CustomerRepository = null;
	@Autowired
	
	// to add product inside MySQL
		private CustomerRepository customerRepository ;
		
        public Customer createCustomer(AddCustomerDao addCustomerDao){
		
		Customer customer = new Customer();

		
	    customer.setCustomerName(addCustomerDao.getCustomerName());
	    customer.setEmail(addCustomerDao.getEmail());
	    customer.setSalary(addCustomerDao.getSalary());
	    
	    
	    customerRepository.save(customer);
	    return customer;
	 
    	}
        
     // To get all customers from my sql
    	
    	public Iterable<Customer> getAllCustomer(){
    		return this.customerRepository.findAll();
    	}
    	
    	// To get specific customer from MySQl
    	
    	
    	public Customer getCustomerById(Integer id) {
    		
    		Customer customer = this.customerRepository.findById(id).orElse(null);
    		
    		if(customer == null) {
    			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Does not Exist");
    		}
    		
    		return customer;
    	}
    	
    	// To delete the specfic customer  from mYsql
    
    	
    	public void deleteCustomer(Integer id) {
    		
    		Customer customer = this.customerRepository.findById(id).orElse(null);
    		
    		if(customer == null) {
    			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Does not Exist");
    		}
    		
    		this.customerRepository.delete(customer);
    	}
    	
    	//to update the customer from MySQL
    	
    	
    	public Customer updateCustomer(Integer id, UpdateCustomerDao updateCustomerDao) {
    		Customer customer = this.getCustomerById(id);
    		
    		if(updateCustomerDao.getCustomerName() != null) {
    			customer.setCustomerName(updateCustomerDao.getCustomerName());
    		}
    		if(updateCustomerDao.getEmail() != null) {
    			customer.setEmail(updateCustomerDao.getEmail());
    		}
    		if(updateCustomerDao.getSalary() != null) {
    			customer.setSalary(updateCustomerDao.getSalary());
    		}
    		
    		this.customerRepository.save(customer);
    		
    		return customer;
    	}
    	
    	// to find the customer by Customer name
    	
    	public List<Customer> getByCustomerName(String customerName){
    		return this.customerRepository.findByCustomerName(customerName);
    	}
    	
    	// to sort the customer by name
    	
    	public List<Customer> sortByCustomerName(){
    		return this.customerRepository.sortByname();
    	}
}