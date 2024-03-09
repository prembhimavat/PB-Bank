package project.bank.dao; 
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.bank.mapper.AccountRowMapper;
import project.bank.model.Account;
 
@Component
public class AccountDaoImpl implements AccountDao {

	@Autowired
	JdbcTemplate jdbcTemplate1;
	
	@Autowired
	JdbcTemplate jdbcTemplate2;
 
	@Override
	public int addAccount(long password, String accountType, double balance, long customerId) {
		String sql="insert into accounts values(default,?,?,?,?)";
		int rec= jdbcTemplate1.update(sql, password, accountType, balance, customerId);
		if(rec>0) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public List<Account> viewAllAccountsByCustomerId(long customerId) {
		String sql="select * from accounts where customerId=?";
		List<Account> accounts=jdbcTemplate1.query(sql,new AccountRowMapper(),customerId);
		return accounts;
	}
	
	@Override
	public Account viewAccountById(long id) {
		String sql="select * from accounts where id=?";
		try {
			Account account=jdbcTemplate1.queryForObject(sql, new AccountRowMapper(),id);
			return account;
		}
		catch(Exception e) {
			return null;
		}
	}
	 	
	@Override
	public boolean updateAccount(Account account) {
		String sql="update accounts set accountType=?, balance=? where id=? and accountPassword=?";
		int rec=jdbcTemplate1.update(sql,account.getAccountType(),account.getBalance(),account.getId(),account.getPassword());
		return rec>0?true:false;
	}
	
	@Override
	public boolean removeAccount(long id) {
		String sql="delete from accounts where id=?";
		int del=jdbcTemplate1.update(sql,id);
		return del>0?true:false;
	}
	
	@Override
	public List<Account> viewAllAccounts() {
		String sql="select * from accounts";
		return jdbcTemplate1.query(sql, new AccountRowMapper());
	}
 
 
	@Override
	public boolean sendMoney(long id, long password, long accountNo, double amount) {
		
		String sql0="select * from accounts where id=? and accountPassword=?";
		try {
			Account account0=jdbcTemplate1.queryForObject(sql0, new AccountRowMapper(),id,password);
			String sql="update accounts set balance=balance-? where id=?";
			int rec=jdbcTemplate1.update(sql,amount,id);
			
			String sql2="update accounts set balance=balance+? where id=?";
			int rec2=jdbcTemplate1.update(sql2,amount,accountNo);
			
			LocalDate date = LocalDate.now();
			Account account=viewAccountById(id);
			String sql3="insert into transactions values(default,?,?,?,?,?)";
			int rec3=jdbcTemplate2.update(sql3,id,accountNo,amount,date,account.getCustomerId());	
			
			return rec>0 && rec2>0 && rec3>0 ? true:false;
		} catch (Exception e) {
			return false;
		}
	}
}
