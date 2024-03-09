package project.bank.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.bank.mapper.TransactionRowMapper;
import project.bank.model.Transaction;

@Component
public class TransactionDaoImpl implements TransactionDao{

	@Autowired
	JdbcTemplate jdbcTemplate2;

	@Override
	public List<Transaction> viewAllByCustomerId(long customerId) {
		String sql="select * from transactions where customerId=?";
		return jdbcTemplate2.query(sql,new TransactionRowMapper(),customerId);
	}
}
