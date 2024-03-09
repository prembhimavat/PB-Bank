package project.bank.dao;


import project.bank.model.Customer;

public interface CustomerDao {
	long addCustomer(Customer customer);
	Customer login(Customer customer);
	Customer searchById(long id);
	
}
