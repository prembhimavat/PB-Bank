package project.bank.dao;

import java.util.List;

import project.bank.model.Transaction;

public interface TransactionDao{
	List<Transaction> viewAllByCustomerId(long customerId);
}
