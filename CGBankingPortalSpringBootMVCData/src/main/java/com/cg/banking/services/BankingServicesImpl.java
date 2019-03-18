package com.cg.banking.services;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.banking.beans.Account;
import com.cg.banking.beans.Transaction;
import com.cg.banking.daoservices.AccountDAO;
import com.cg.banking.daoservices.TransactionDAO;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
@Component("bankingServices")
public class BankingServicesImpl implements BankingServices{
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private TransactionDAO transactionDao;
	Scanner sc = new Scanner(System.in);
	@Override
	public Account openAccount(Account account)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {

		int pinNumber =(int)(Math.random()*10000);
		if(pinNumber<1000)
			pinNumber=pinNumber*10;
		else if (pinNumber<100)
			pinNumber=pinNumber*100;
		else if(pinNumber<10)
			pinNumber=pinNumber*1000;

		//String accountStatus="ACTIVE";
		HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
account.setAccountStatus("ACTIVE");
account.setPinNumber(pinNumber);
		//Account account = new Account(pinNumber, accountType, accountStatus, initBalance, transactions);

//		if(account.getAccountBalance()<1000)
//			throw new InvalidAmountException("Invalid initial amount");
//		else if(account.getAccountType().isEmpty())
//			throw new InvalidAccountTypeException("Account type is not valid");
//		else
			account = accountDao.save(account);
		return account;
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);

		if(account.getAccountStatus().equalsIgnoreCase("ACTIVE")) {
			float newAmount = account.getAccountBalance() + amount;
			account.setAccountBalance(newAmount);
			Transaction transaction = new Transaction(amount , "DEPOSITED" , account);
			transactionDao.save(transaction);
			accountDao.save(account);
			return newAmount;
		}
		else 
			throw new AccountBlockedException("This account has been blocked");
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
	AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account account = getAccountDetails(accountNo);
		if(account.getAccountStatus().equalsIgnoreCase("ACTIVE")){
			for(int i =0;i<2;i++){
				if(account.getPinNumber()==pinNumber){
					float newAmount = account.getAccountBalance() - amount ; 
					if(newAmount < 500) 
						throw new InsufficientAmountException("Balance cannot go below 500");
					else {
						account.setAccountBalance(newAmount);
						Transaction transaction = new  Transaction(amount, "WITHDRAW" , account);
						transactionDao.save(transaction);
						accountDao.save(account);
					}
					return newAmount;
				}
				else{
					System.out.println("Your PIN is wrong . Kindly enter again");
					pinNumber = sc.nextInt();
				}
			}
			account.setAccountStatus("BLOCKED");
			throw new InvalidPinNumberException("YOU HAVE EXCEEDED PIN ENTERING LIMIT");
		}
		else 
			throw new AccountBlockedException("YOUR ACCOUNT HAS BEEN BLOCKED");
	}

	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
		float balAmount = withdrawAmount(accountNoFrom, transferAmount, pinNumber);
		depositAmount(accountNoTo, transferAmount);
//		accountDao.update(getAccountDetails(accountNoFrom));
//		accountDao.update(getAccountDetails(accountNoTo));
		if(balAmount!=0.00f) 
			return true;
		else
			return false;
	}
	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		return accountDao.findById(accountNo).orElseThrow(()->new AccountNotFoundException("Account not found for account number = "+accountNo));
		
	}

	@Override
	public List<Account> getAllAccountsDetails() throws BankingServicesDownException {	
		return accountDao.findAll();
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountBlockedException {
		return transactionDao.findAll();
	}
}
