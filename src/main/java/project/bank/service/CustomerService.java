package project.bank.service;

import project.bank.model.Customer;

public interface CustomerService {
		long signup(Customer customer);
		Customer signIn(Customer customer);
		Customer viewProfile(long id);
}
