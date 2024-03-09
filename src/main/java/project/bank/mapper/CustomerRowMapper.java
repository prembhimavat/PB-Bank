package project.bank.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import project.bank.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong(1));
		customer.setName(rs.getString(2));
		customer.setEmail(rs.getString(3));
		customer.setPassword(rs.getString(4));
		customer.setAadharNumber(rs.getString(5));
		customer.setPanNumber(rs.getString(5));
		return customer;
	}
}
