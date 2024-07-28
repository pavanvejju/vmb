package com.vmb.enterprise.service;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.model.Customer;

import java.util.List;

public interface ICustomerService {
	Customer updateUser(Long id, String status);
	List<Customer> fetchAllCustomers();
	void save(CustomerRequestDto customerRequestDto);
	String saveAllCustomers(List<CustomerRequestDto> customerRequestDtoList);
}
