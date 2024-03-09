package project.bank.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.bank.dao.CustomerDao;
import project.bank.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public long signup(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}
	@Override
	public Customer signIn(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.login(customer);
	}

	@Override
	public Customer viewProfile(long id) {
		// TODO Auto-generated method stub
		return customerDao.searchById(id);
	}
}
