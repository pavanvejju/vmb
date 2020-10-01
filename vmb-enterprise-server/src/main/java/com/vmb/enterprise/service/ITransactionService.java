package com.vmb.enterprise.service;

import java.util.List;

import com.vmb.enterprise.dto.TransactionRequestDto;
import com.vmb.enterprise.model.Transaction;

public interface ITransactionService {

	public Transaction saveTransaction(TransactionRequestDto transactionRequestDto);

	public String saveAllTransaction(List<TransactionRequestDto> transactionRequestDtoList);

	public List<TransactionRequestDto> fetchAllTransactions();
}
