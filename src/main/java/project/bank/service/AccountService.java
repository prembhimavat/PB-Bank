package project.bank.service;

import java.util.List;

import project.bank.model.Account;

public interface AccountService {
	int addAccount(long password, String accountType, double balance, long customerId);
	List<Account> viewAllAccountsByCustomerId(long customerId);
	Account viewAccountById(long id);
	boolean updateAccount(Account account);
	boolean removeAccount(long id);
	List<Account> viewAll();
	boolean sendMoney(long id, long password, long accountNo, double amount);
}
