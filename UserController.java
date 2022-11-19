package com.codewitharjun.fullstackbackend.controller;
import com.codewitharjun.fullstackbackend.model.Transaction;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.TransactionRepo;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import com.codewitharjun.fullstackbackend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://192.168.0.106:8080")
public class UserController {
		
	@Autowired
	private UserService userservice;
		
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TransactionRepo transactionRepo;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    
  @PostMapping("/transaction")
   Transaction newTransaction(@RequestBody Transaction newTransaction) {
       return transactionRepo.save(newTransaction);
    }
     
    @GetMapping("/users/{accno}")
    public User users(@PathVariable int accno) {
    	return userservice.users(accno);
    }
    
    @GetMapping("/history/{accno}")
    public List<Transaction> history(@PathVariable int accno){
    	return userservice.history(accno);
    }
    
    @PostMapping("/deposit/{accno}/{amount}")
    	public String deposit(@PathVariable int accno,@PathVariable int amount) {
    	
    	return userservice.depositamount(accno,amount);
    }
    
    @PostMapping("/withdraw/{accno}/{amount}")
	public String withdraw(@PathVariable int accno,@PathVariable int amount) {
	return userservice.withdrawamount(accno,amount);
    }
    
    @PostMapping("/transfer/{accno}/{acc2}/{amount}")
	public String transfer(@PathVariable int accno,@PathVariable int acc2,@PathVariable int amount) {
	return userservice.transferamount(accno,acc2,amount);
    }
    
    @GetMapping("/viewbalance/{accno}")
    	public User viewbalance(@PathVariable int accno) {
    	return userservice.viewbalance(accno);
    }
       
}