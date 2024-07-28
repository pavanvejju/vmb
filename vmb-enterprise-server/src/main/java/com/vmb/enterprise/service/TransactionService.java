package com.vmb.enterprise.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.model.Customer;
import com.vmb.enterprise.model.Payment;
import com.vmb.enterprise.model.Transaction;
import com.vmb.enterprise.repository.CustomerRepository;
import com.vmb.enterprise.repository.PaymentRepository;
import com.vmb.enterprise.repository.TransactionRepository;
import com.vmb.enterprise.utils.CustomUtils;

@Service
public class TransactionService implements ITransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	@Override
	public List<TransactionRequestDto> fetchAllTransactions() {
		
		
		List<TransactionRequestDto> transactionRequestDtoList	=	new ArrayList<TransactionRequestDto>();
		List<Transaction>	TransactionList	=	transactionRepository.findAll();
		for(Transaction transaction: TransactionList) {
			TransactionRequestDto transactionRequestDto	=	new TransactionRequestDto(
					transaction.date().toString(),
					transaction.type(),
					transaction.description(),
					transaction.amount(),
					transaction.customer().id(),
					transaction.customer().customerName(),
					transaction.createdBy(),
					transaction.createdDate().toString()
					);
			transactionRequestDtoList.add(transactionRequestDto);
		}
		return transactionRequestDtoList;	
	}
	
	@Transactional
	@Override
	public Transaction saveTransaction(TransactionRequestDto transactionRequestDto) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = formatter.parse(transactionRequestDto.dateStr());
            System.out.println(formatter.format(date));
	        
			Customer customer	=	customerRepository.findById(transactionRequestDto.customerId()).orElse(null);
			if(customer!=null) {
				Payment payment	=	paymentRepository.findByCustomerId(customer.id());
				if(payment!=null) {
					Payment payment1 = CustomUtils.constructDtoToPaymentByTransaction(transactionRequestDto, payment);
					paymentRepository.saveAndFlush(payment1);
					
					Transaction transaction	=	new Transaction(0, date,
							transactionRequestDto.type(),
							transactionRequestDto.description(),
							transactionRequestDto.amount(),
							transactionRequestDto.createdBy(),
							new Timestamp(System.currentTimeMillis()),
							customer, payment1
							);
					return transactionRepository.saveAndFlush(transaction);
				}
			}
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	@Transactional
	@Override
	public String saveAllTransaction(List<TransactionRequestDto> transactionRequestDtoList) {
	
		for(TransactionRequestDto transactionRequestDto:transactionRequestDtoList) {
			saveTransaction(transactionRequestDto);
		}
		return "SUCCESS";
	}
}
