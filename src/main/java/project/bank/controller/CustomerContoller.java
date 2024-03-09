package project.bank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.bank.model.Customer;
import project.bank.model.Transaction;
import project.bank.service.CustomerService;
import project.bank.service.TransactionService;

@Component
@RequestMapping("/customers")
public class CustomerContoller {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	TransactionService transactionService;

	@RequestMapping(path = "signup", method = RequestMethod.POST) // by default it is get.
	public ModelAndView signup(Customer customer) {
		long id = customerService.signup(customer);
		String message = "";
		ModelAndView mv = new ModelAndView();
		if (id > 0) {
			message = "Sign Up Successfull with ID: " + id;
			mv.addObject("message", message);
			mv.setViewName("/views/signUp.jsp");
		} else {
			message = "Error!";
			mv.addObject("message", message);
			mv.setViewName("/views/signUp.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(path = "login", method = RequestMethod.POST) 
	public ModelAndView login(Customer customer, HttpSession session) {
		Customer customer1 = customerService.signIn(customer); 
		String message = "";
		ModelAndView mv = new ModelAndView();
		if (customer1 != null) {
			long customerId = customer1.getId();
			session.setAttribute("customerID", customerId);
			mv = new ModelAndView("redirect:/customers/dashboard");
		} else {
			message = "Invalid Credentials!";
			mv.addObject("message", message);
			mv.setViewName("/views/login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("dashboard") 
	public ModelAndView dashboard(HttpSession session) {
		long custId = (long)session.getAttribute("customerID");
		Customer customer1 = customerService.viewProfile(custId);
		ModelAndView mv = new ModelAndView();
		List<Transaction> transactions=transactionService.viewAllByCustomerId(custId);
		mv.addObject("transaction",transactions);
		mv.addObject("customer", customer1);
		mv.setViewName("/views/dashboard.jsp");
		return mv;
	}
	
	@RequestMapping("logout") 
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		session.removeAttribute("customerID");
		mv.setViewName("/views/login.jsp");
		return mv;
	}
}