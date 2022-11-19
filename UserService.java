package com.codewitharjun.fullstackbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewitharjun.fullstackbackend.model.Transaction;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.TransactionRepo;
import com.codewitharjun.fullstackbackend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private TransactionRepo transactionrepo;
	
	
		
	public User users(int accno) {
		if(userrepo.existsById(accno)){
			return userrepo.findById(accno).get();
		}
		else {
			return null;
		}
	}
	
	public List<Transaction> history(int accno) {
		return transactionrepo.findAll();
		
	}
	
	
//	public String saveuser(int accno,String trn_type,int amount,int acc2) {
//		Transaction transaction = new Transaction();
//		
//		transaction.setAccno(accno);
//		transaction.setTrn_type(trn_type);
//		transaction.setAmount(amount);
//		transaction.setAcc2(acc2);
//		transactionrepo.save(transaction);
//		return "Transaction saved";
//		
//	}
	
	public String depositamount(int accno,int amount) {
		User user = userrepo.findById(accno).get();
		user.setBalance(user.getBalance()+amount);
		
		userrepo.save(user);
		return "Amount is deposited";
	}
	
	public String withdrawamount(int accno,int amount) {
		if(userrepo.findById(accno).get().getBalance()>amount) {
			User user = userrepo.findById(accno).get();
			user.setBalance(user.getBalance()-amount);
			userrepo.save(user);
			return "Amount is withdrawn";
		}
		else {
			return "Account Balance is low";
		}
	}
	public String transferamount(int accno,int acc2,int amount) {
		if(accno!=acc2) {
		if(userrepo.existsById(acc2)) {
			if(userrepo.findById(accno).get().getBalance()>amount) {
				User user = userrepo.findById(accno).get();
				User user1 = userrepo.findById(acc2).get();
				user.setBalance(user.getBalance()-amount);
				user1.setBalance(user1.getBalance()+amount);
				userrepo.save(user);
				userrepo.save(user1);
				return "Transaction Successful";
				}
			 else {
				return "Account Balance is low";
				 }
				}
		else {
			return "Receiver's Account doesn't Exist";
			}
		 }
		else {
			return "Transferring to the same account";
		}
		}
	
	
	public User viewbalance(int accno) {
		if(userrepo.existsById(accno)) {
			return userrepo.findById(accno).get();
		}
		else {
			return null;
		}
	}
	
	
	
	
	
	
	
}
