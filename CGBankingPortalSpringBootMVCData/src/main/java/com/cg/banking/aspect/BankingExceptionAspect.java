package com.cg.banking.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;

@ControllerAdvice
public class BankingExceptionAspect {
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleAccountNotFoundException(Exception e) {
		return new ModelAndView("findAccountDetailsPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidAmountException.class)
	public ModelAndView handleInvalidAmountException(Exception e) {
		return new ModelAndView("openAccountPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(InvalidAccountTypeException.class)
	public ModelAndView handleInvalidAccountTypeException(Exception e) {
		return new ModelAndView("openAccountPage", "errorMessage", e.getMessage());
	}
	@ExceptionHandler(BankingServicesDownException.class)
	public ModelAndView handleBankingServicesDownException(Exception e) {
		return new ModelAndView("openAccountPage", "errorMessage", e.getMessage());
	}
}
