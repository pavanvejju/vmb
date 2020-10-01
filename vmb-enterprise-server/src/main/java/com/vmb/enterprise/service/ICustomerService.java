package com.vmb.enterprise.service;

import java.util.List;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.model.Customer;

public interface ICustomerService {
	
	
	public Customer updateUser(Long id, String status);
	
	public List<Customer> fetchAllCustomers();

	public void save(CustomerRequestDto customerRequestDto);

	public String saveAllCustomers(List<CustomerRequestDto> customerRequestDtoList);
}
