package project.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.bank.model.Account;
import project.bank.model.Customer;
import project.bank.service.AccountService;
import project.bank.service.CustomerService;

@Component
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	CustomerService customerService;

	@RequestMapping(path = "addaccount", method = RequestMethod.POST)
	public ModelAndView addAccount(long password, String accountType, double balance, long customerId) {
		int id1 = accountService.addAccount(password, accountType, balance, customerId);
		String message = "";
		ModelAndView mv = new ModelAndView();
		if (id1 > 0) {
			message = "Account added sucessfully..";
			mv = new ModelAndView("redirect:../customers/dashboard");
		} else {
			message = "Some unknown error occured...Please try after sometime";
			mv.addObject("message", message);
			mv.setViewName("/views/account.jsp");
		}
		return mv;
	}

	
	  @RequestMapping("addaccountview") 
	  public ModelAndView profile(HttpSession session) { 
		  ModelAndView mv = new ModelAndView(); 
		  long custId = (long)session.getAttribute("customerID");
		  Customer customer = customerService.viewProfile(custId); 
		  mv.addObject("customer", customer);
		  mv.setViewName("/views/account.jsp"); 
		  return mv;  
	  }
	 

	@RequestMapping("customeraccountview")
	public ModelAndView accountview(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		long custId = (long)session.getAttribute("customerID");
		List<Account> accounts = accountService.viewAllAccountsByCustomerId(custId);
		mv.addObject("account", accounts);
		mv.addObject("accounts", custId);
		mv.setViewName("/views/viewAll.jsp");
		return mv;
	}

	@RequestMapping("updateaccount")
	public ModelAndView updateAccount(@RequestParam long id) {
		ModelAndView mv = new ModelAndView();
		Account account = accountService.viewAccountById(id);
		mv.addObject("account", account);
		mv.setViewName("/views/updateaccount.jsp");
		return mv;
	}

	
	@RequestMapping(path = "update", method = RequestMethod.POST)
	public ModelAndView update(Account account) {
		boolean check = accountService.updateAccount(account);
		ModelAndView mv = new ModelAndView();
		if(check) {
			mv = new ModelAndView("redirect:/accounts/customeraccountview");			
		} else {
			mv.addObject("message", "Invalid pin!");
			mv.setViewName("/views/updateaccount.jsp");
		}
		return mv;
	}

	@RequestMapping(path = "delete", method = RequestMethod.GET)
	public ModelAndView deleteProfile(@RequestParam long id) {
		Account account = accountService.viewAccountById(id);
		boolean account3 = accountService.removeAccount(id);
		ModelAndView mv = new ModelAndView();
		mv = new ModelAndView("redirect:/accounts/customeraccountview");
		return mv;
	}

	@RequestMapping(path = "sendmoney", method = RequestMethod.GET)
	public ModelAndView sendmoney(@RequestParam int id) {
		List<Account> accounts = accountService.viewAll();
		Account account = accountService.viewAccountById(id);
		List<Account> accounts2 = new ArrayList<>();
		for (Account acc : accounts) {
			if (acc.getId() != id) {
				accounts2.add(acc);
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("account", accounts2);
		mv.addObject("balance", account.getBalance());
		mv.addObject("id", id);
		mv.setViewName("/views/transaction.jsp");
		return mv;

	}

	@RequestMapping(path="transactions", method= RequestMethod.POST)
	public ModelAndView transaction(long id, long password, long accountNo,double balance,double amount) {
		ModelAndView mv= new ModelAndView();
			if(amount<balance) {
				boolean sendMoney = accountService.sendMoney(id, password, accountNo, amount);
				if(sendMoney) {
					mv= new ModelAndView("redirect:/accounts/customeraccountview");
				} else {
					List<Account> accounts=accountService.viewAll();
					Account account3=accountService.viewAccountById(id);
					List<Account> accounts4=new ArrayList<>();
					for(Account acc:accounts) {
						if(acc.getId()!=id) {
							accounts4.add(acc);
						}
					}
					mv.addObject("message","Invalid Pin!");	
					mv.addObject("account",accounts4);
					mv.addObject("balance",account3.getBalance());
					mv.addObject("id",id);
					mv.setViewName("/views/transaction.jsp");
				}
			} else {
				List<Account> accounts=accountService.viewAll();
				Account account3=accountService.viewAccountById(id);
				List<Account> accounts4=new ArrayList<>();
				for(Account acc:accounts) {
					if(acc.getId()!=id) {
						accounts4.add(acc);
					}
				}
				mv.addObject("message","Insufficient balance!");	
				mv.addObject("account",accounts4);
				mv.addObject("balance",account3.getBalance());
				mv.addObject("id",id);
				mv.setViewName("/views/transaction.jsp");
			}
		return mv;
	}
}