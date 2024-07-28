package com.vmb.enterprise.service;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.enums.CustomerStatusEnum;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Payment;
import com.vmb.enterprise.repository.CustomerRepository;
import com.vmb.enterprise.utils.CustomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PaymentService paymentService;
	
	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);


	@Transactional
	@Override
	public Customer updateUser(Long id, String status) {
		
		Optional<Customer> customerOptional	=	customerRepository.findById(id);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customer.customerWithStatus(status);
			return customerRepository.save(customer);
		}
		return null;
	}
	
	@Transactional
	@Override
	public List<Customer> fetchAllCustomers() {
		return	 customerRepository.findAll();	
	}
	
	@Transactional
	@Override
	public void save(CustomerRequestDto customerRequestDto) {
		
		try {
			Customer customer	=	new Customer(0,
					customerRequestDto.firstName(),
					customerRequestDto.lastName(),
					customerRequestDto.middleName(),
					customerRequestDto.customerName(),
					customerRequestDto.emailId(),
					customerRequestDto.phoneNumber(),
					customerRequestDto.village(),
					customerRequestDto.mandal(),
					customerRequestDto.pincode(),
					customerRequestDto.address(),
					customerRequestDto.aadhaarCardNumber(),
					CustomerStatusEnum.ACTIVE.strCode,
					customerRequestDto.type(),
					customerRequestDto.createdBy(),
					new Timestamp(System.currentTimeMillis()),
					customerRequestDto.createdBy(),
					new Timestamp(System.currentTimeMillis())
			);
			Customer result	=	customerRepository.saveAndFlush(customer);
			Payment payment = CustomUtils.constructDtoToPaymentByCustomer(customerRequestDto, result);
			paymentService.savePayment(payment);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public String saveAllCustomers(List<CustomerRequestDto> customerRequestDtoList) {
		for(CustomerRequestDto customerRequestDto:customerRequestDtoList) {
			save(customerRequestDto);
		}
		return "SUCCESS";
	}
}