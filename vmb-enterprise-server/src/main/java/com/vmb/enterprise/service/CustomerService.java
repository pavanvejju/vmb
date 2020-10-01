package com.vmb.enterprise.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmb.enterprise.dto.CustomerRequestDto;
import com.vmb.enterprise.enums.CustomerStatusEnum;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Payment;
import com.vmb.enterprise.repository.CustomerRepository;
import com.vmb.enterprise.utils.CustomUtils;

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
		
		Optional<Customer> user	=	customerRepository.findById(id);
		if(user.isPresent()) {
			user.get().setStatus(status);
			return customerRepository.save(user.get());
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
			Customer customer	=	new Customer();
				customer.setFirstName(customerRequestDto.getFirstName());
				customer.setLastName(customerRequestDto.getLastName());
				customer.setMiddleName(customerRequestDto.getMiddleName());
				customer.setCustomerName(customerRequestDto.getCustomerName());
				customer.setEmailId(customerRequestDto.getEmailId());
				customer.setAadhaarCardNumber(customerRequestDto.getAadhaarCardNumber());
				customer.setAddress(customerRequestDto.getAddress());
				customer.setMandal(customerRequestDto.getMandal());
				customer.setPincode(customerRequestDto.getPincode());
				customer.setPhoneNumber(customerRequestDto.getPhoneNumber());
				customer.setType(customerRequestDto.getType());
				customer.setVillage(customerRequestDto.getVillage());
				customer.setStatus(CustomerStatusEnum.ACTIVE.strCode);
				customer.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				customer.setCreatedBy(customerRequestDto.getCreatedBy());
				customer.setModifiedDate(new Timestamp(System.currentTimeMillis()));
				customer.setModifiedBy(customerRequestDto.getCreatedBy());
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
