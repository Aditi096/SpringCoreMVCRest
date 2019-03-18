package com.cg.banking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.banking.beans.Account;

@Controller
public class URIController {
	private Account account;
	@RequestMapping(value= {"/","index"})
	public String getIndexPage() {
		return "indexPage";
	}
	@RequestMapping("/openAccount")
	public String getOpenAccountPage() {
		return "openAccountPage";
	}
	@RequestMapping("/findAccountDetails")
	public String getfindAccountDetailsPage() {
		return "findAccountDetailsPage";
	}
	@RequestMapping("/depositAmount")
	public String getDepositAmountPage() {
		return "depositAmountPage";
	}
	@RequestMapping("/withdrawAmount")
	public String getWithdrawAmountPage() {
		return "withdrawAmountPage";
	}
	@ModelAttribute
	public Account getAccount() {
		account = new Account();
		return account;
	}
}
