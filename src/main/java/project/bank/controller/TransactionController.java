package project.bank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.bank.model.Transaction;
import project.bank.service.TransactionService;

@Component
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@RequestMapping("transactionview")
	public ModelAndView transactionview(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		long custId = (long)session.getAttribute("customerID");
		List<Transaction> transactions=transactionService.viewAllByCustomerId(custId);
		mv.addObject("transaction",transactions);
		mv.addObject("customerId", custId);
		mv.setViewName("/views/viewAllTransactions.jsp");
		return mv;
	}
}
