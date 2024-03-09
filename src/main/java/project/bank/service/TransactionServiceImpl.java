package project.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.bank.dao.TransactionDao;
import project.bank.model.Transaction;

@Component
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDao transactionDao;

	@Override
	public List<Transaction> viewAllByCustomerId(long customerId) {
		return transactionDao.viewAllByCustomerId(customerId);
	}
}
