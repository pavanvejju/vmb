package com.vmb.enterprise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.exception.ResourceNotFoundException;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.repository.CustomerRepository;
import com.vmb.enterprise.service.ICustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers() {
		System.out.println("getCustomers:::");
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long CustomerId)
			throws ResourceNotFoundException {
		Customer Customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));
		return ResponseEntity.ok().body(Customer);
	}

	@PostMapping("/add")
	public String createCustomer(@RequestBody CustomerRequestDto customerRequestDto ) {
		customerService.save(customerRequestDto);
		
		return "Success";
	}
	
	@PostMapping("/addAll")
	public String createCustomers(@RequestBody List<CustomerRequestDto> customerRequestDtoList) {
		return customerService.saveAllCustomers(customerRequestDtoList);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long CustomerId,
			@RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
		Customer Customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

		Customer.setFirstName(CustomerDetails.getFirstName());
		Customer.setMiddleName(CustomerDetails.getMiddleName());
		Customer.setLastName(CustomerDetails.getLastName());
		Customer.setEmailId(CustomerDetails.getEmailId());
		Customer.setPhoneNumber(CustomerDetails.getPhoneNumber());
		Customer.setVillage(CustomerDetails.getVillage());
		Customer.setMandal(CustomerDetails.getMandal());
		Customer.setPincode(CustomerDetails.getPincode());
		Customer.setAddress(CustomerDetails.getAddress());
		
		final Customer updatedCustomer = customerRepository.save(Customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long CustomerId)
			throws ResourceNotFoundException {
		Customer Customer = customerRepository.findById(CustomerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + CustomerId));

		customerRepository.delete(Customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}