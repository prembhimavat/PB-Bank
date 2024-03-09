package project.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.bank.model.Transaction;

public class TransactionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(rs.getLong(1));
		transaction.setSenderId(rs.getLong(2));
		transaction.setReceiverId(rs.getLong(3));
		transaction.setAmount(rs.getDouble(4));
		transaction.setTransactionDate(rs.getDate(5));
		transaction.setCustomerId(rs.getLong(6));
		return transaction;
	}
}
