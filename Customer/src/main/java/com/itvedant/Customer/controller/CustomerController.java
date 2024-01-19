package com.itvedant.Customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.Customer.dao.AddCustomerDao;
import com.itvedant.Customer.dao.UpdateCustomerDao;
import com.itvedant.Customer.services.CustomerService;




@RestController
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	 private CustomerService customerSevice;
	
	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody AddCustomerDao addCustomerDao){
		return ResponseEntity.ok(this.customerSevice.createCustomer(addCustomerDao));
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllCustomer(){
		return ResponseEntity.ok(this.customerSevice.getAllCustomer());
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(this.customerSevice.getCustomerById(id));
	}
	@DeleteMapping("/{id}")
	
	public String delete(@PathVariable Integer id){
		this.customerSevice.deleteCustomer(id);
		return "Customer has been Deleted";
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id,@RequestBody UpdateCustomerDao updateCustomerDao){
		return ResponseEntity.ok(this.customerSevice.updateCustomer(id, updateCustomerDao));
	}
	@GetMapping("search/findbycustomername")
	public ResponseEntity<?> findByName(@RequestParam String customername){
		return ResponseEntity.ok(this.customerSevice.getByCustomerName(customername));
	}
	

	@GetMapping("/search/sortbyname")
	public ResponseEntity<?> sortName(){
		return ResponseEntity.ok(this.customerSevice.sortByCustomerName());
	}
}
