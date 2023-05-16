package com.vmb.enterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.exception.ResourceNotFoundException;
import com.vmb.enterprise.model.Transaction;
import com.vmb.enterprise.repository.TransactionRepository;
import com.vmb.enterprise.service.ITransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private ITransactionService transactionService;
	
	@GetMapping("/")
	public List<TransactionRequestDto> fetchAllTransactions() {
		System.out.println("fetchAllTransactions:::");
		return transactionService.fetchAllTransactions();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Transaction> getTransactionById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Transaction transaction = transactionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction not found for this id :: " + id));
		return ResponseEntity.ok().body(transaction);
	}

	@PostMapping("/add")
	public Transaction addTransaction(@RequestBody TransactionRequestDto transactionRequestDto) {
		return transactionService.saveTransaction(transactionRequestDto);
	}
	
	@PostMapping("/addAll")
	public String addTransaction(@RequestBody List<TransactionRequestDto> transactionRequestDtoList) {
		return transactionService.saveAllTransaction(transactionRequestDtoList);
	}

}