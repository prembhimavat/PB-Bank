package project.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.bank.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setId(rs.getLong(1));
		account.setPassword(rs.getLong(2));
		account.setAccountType(rs.getString(3));
		account.setBalance(rs.getDouble(4));
		account.setCustomerId(rs.getInt(5));
		return account;
	}
}