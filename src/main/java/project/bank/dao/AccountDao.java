package project.bank.dao;

import java.util.List;

import project.bank.model.Account;

public interface AccountDao {
	int addAccount(long password, String accountType, double balance, long customerId);
	List<Account> viewAllAccountsByCustomerId(long customerId);
	Account viewAccountById(long id);
	boolean updateAccount(Account account);
	boolean removeAccount(long id);
	List<Account> viewAllAccounts();
	boolean sendMoney(long id, long password, long accountNo, double amount);
}
