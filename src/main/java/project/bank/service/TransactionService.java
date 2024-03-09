package project.bank.service;

import java.util.List;

import project.bank.model.Transaction;

public interface TransactionService {
	List<Transaction> viewAllByCustomerId(long customerId);
}
