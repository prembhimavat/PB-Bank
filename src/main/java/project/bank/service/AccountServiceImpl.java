package project.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.bank.dao.AccountDao;
import project.bank.model.Account;

@Component
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

	@Override
	public int addAccount(long password, String accountType, double balance, long customerId) {
		return accountDao.addAccount(password, accountType, balance, customerId);
	}

	@Override
	public List<Account> viewAllAccountsByCustomerId(long customerId) {
		return accountDao.viewAllAccountsByCustomerId(customerId);
	}

	@Override
	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	@Override
	public Account viewAccountById(long id) {
		return accountDao.viewAccountById(id);
	}

	@Override
	public boolean removeAccount(long id) {
		return accountDao.removeAccount(id);
	}

	@Override
	public List<Account> viewAll() {
		return accountDao.viewAllAccounts();
	}

	@Override
	public boolean sendMoney(long id, long password, long accountNo, double amount) {
		return accountDao.sendMoney(id, password, accountNo, amount);
	}
	
}
