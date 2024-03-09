package project.bank.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import project.bank.mapper.CustomerRowMapper;
import project.bank.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	public long addCustomer(Customer customer) {
		String sql = "insert into customers values(default,?,?,?,?,?)";
		int res = jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getPassword(), customer.getAadharNumber(), customer.getPanNumber());
		
		if(res>0) {
			String sql1="select * from customers where id="+"(select max(id) from customers)";
			Customer customer1=jdbcTemplate.queryForObject(sql1, new CustomerRowMapper());
			return customer1.getId();
		}
		return 0;
	}
	
	public Customer login(Customer customer) {
		String sql = "select * from customers where id=? and password=?";
		try {
			Customer customer1 = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), customer.getId(), customer.getPassword());
			return customer1;			
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public Customer searchById(long id) {
		String sql = "select * from customers where id=?";
		try {
			Customer customer = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(), id);
			return customer;			
		} catch(Exception e) {
			return null;
		}
	}	
}