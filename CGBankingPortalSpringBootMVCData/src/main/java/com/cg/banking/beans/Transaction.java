package com.cg.banking.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	private float amount;
	private String transactionType;
	private long accountInit;
	private long accountFinal;
	@ManyToOne
	private Account account;
	public Transaction() {	}
	
public Transaction(float amount, String transactionType, Account account) {
		super();
		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
	}

//	public Transaction(int transactionId, float amount, String transactionType, long accountInit, long accountFinal,
//			Account account) {
//		super();
//		this.transactionId = transactionId;
//		this.amount = amount;
//		this.transactionType = transactionType;
//		this.accountInit = accountInit;
//		this.accountFinal = accountFinal;
//		this.account = account;
//	}
//
//	public Transaction(float amount, String transactionType) {
//		super();
//		this.amount = amount;
//		this.transactionType = transactionType;
//	}
//
//	public Transaction(int transactionId, float amount, String transactionType) {
//		super();
//		this.transactionId = transactionId;
//		this.amount = amount;
//		this.transactionType = transactionType;
//	}
//	
//	public Transaction(float amount, String transactionType, long accountInit, long accountFinal) {
//		super();
//		this.amount = amount;
//		this.transactionType = transactionType;
//		this.accountInit = accountInit;
//		this.accountFinal = accountFinal;
//	}
//	
//	public Transaction(float amount, String transactionType, long accountInit) {
//		super();
//		this.amount = amount;
//		this.transactionType = transactionType;
//		this.accountInit = accountInit;
//	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getAccountInit() {
		return accountInit;
	}
	public void setAccountInit(long accountInit) {
		this.accountInit = accountInit;
	}
	public long getAccountFinal() {
		return accountFinal;
	}
	public void setAccountFinal(long accountFinal) {
		this.accountFinal = accountFinal;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", transactionType="
				+ transactionType + ", accountInit=" + accountInit + ", accountFinal=" + accountFinal + ", account="
				+ account + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (int) (accountFinal ^ (accountFinal >>> 32));
		result = prime * result + (int) (accountInit ^ (accountInit >>> 32));
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + transactionId;
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (accountFinal != other.accountFinal)
			return false;
		if (accountInit != other.accountInit)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	
	
}
