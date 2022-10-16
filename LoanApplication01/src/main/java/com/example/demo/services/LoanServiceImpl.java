package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LoanEntity;
import com.example.demo.repository.LoanRepo;


@Service
public class LoanServiceImpl{

    LoanEntity entity=new LoanEntity();	
	@Autowired
	private LoanRepo repository;
	@Autowired
	LoanScheduleServices loanScheduleService;
	
	public List<LoanEntity> printloan() {
		return repository.findAll();
	}
	
	
	public LoanEntity saveLone(LoanEntity loanEntity) {
		
		loanEntity.setTradeDate(LocalDate.now());
		loanEntity.setLoanStartDate(LocalDate.now());
		
		loanEntity.setMaturityDate(loanEntity.getTradeDate().plusYears(loanEntity.getTenure()));
        loanEntity.setSchedule(loanScheduleService.saveSchedule(loanEntity));
		
		return repository.save(loanEntity);
//		entity.setLoanAmount(loanEntity.getLoanAmount());
//		entity.setTradeDate(LocalDate.now());
//		entity.setLoanStartDate(LocalDate.now());
//		entity.setMaturityDate(loanEntity.getLoanStartDate().plusYears(loanEntity.getPaymentFrequency()));
//		entity.setPaymentFrequency(loanEntity.getPaymentFrequency());
//		entity.setInterestRate(loanEntity.getInterestRate());
//		
//		return loanEntity;
	}

}
