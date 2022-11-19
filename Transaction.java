package com.codewitharjun.fullstackbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private int accno;
	private String trn_type;
	private int amount;
	private int acc2;
	
	
	
	
//	public long getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getTrn_type() {
		return trn_type;
	}
	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAcc2() {
		return acc2;
	}
	public void setAcc2(int acc2) {
		this.acc2 = acc2;
	}
	
	
	

}
