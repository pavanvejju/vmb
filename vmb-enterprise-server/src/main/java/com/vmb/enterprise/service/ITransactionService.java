package com.vmb.enterprise.service;

import java.util.List;

import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.model.Transaction;

public interface ITransactionService {
	Transaction saveTransaction(TransactionRequestDto transactionRequestDto);
	String saveAllTransaction(List<TransactionRequestDto> transactionRequestDtoList);
	List<TransactionRequestDto> fetchAllTransactions();
}
