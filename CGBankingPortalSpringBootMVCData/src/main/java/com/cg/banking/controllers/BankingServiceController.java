package com.cg.banking.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.services.BankingServices;

@Controller
public class BankingServiceController {
	@Autowired
	BankingServices bankingServices;
	@RequestMapping("/openAccount12")
	public ModelAndView openAccount(@Valid@ModelAttribute Account account,BindingResult result) {
		if(result.hasErrors())return new ModelAndView("openAccountPage");
		account=bankingServices.openAccount(account);
		return new ModelAndView("openAccountPage", "account", account);
	}
	@RequestMapping("/accountDetails")
	public ModelAndView getAccountDetails(@RequestParam long accountNo)throws AccountNotFoundException{
		Account account=bankingServices.getAccountDetails(accountNo);
		return new ModelAndView("findAccountDetailsPage", "account", account);
	}
	@RequestMapping("/depositAmount12")
	public ModelAndView depositAmount(@RequestParam long accountNo,float depositBalance) {
		float accountBalance=bankingServices.depositAmount(accountNo, depositBalance);
		return new ModelAndView("depositAmountPage", "accountBalance", accountBalance);
	}
	@RequestMapping("/withdrawAmount12")
	public ModelAndView withdrawAmount(@RequestParam long accountNo,float withdrawBalance) {
		float accountBalance=bankingServices.depositAmount(accountNo, withdrawBalance);
		return new ModelAndView("depositAmountPage", "accountBalance", accountBalance);
	}
}
