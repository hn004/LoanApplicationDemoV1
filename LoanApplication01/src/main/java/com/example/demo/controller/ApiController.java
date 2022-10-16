package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.LoanEntity;
import com.example.demo.Entity.ScheduleEntity;
import com.example.demo.services.LoanScheduleServices;
import com.example.demo.services.LoanServiceImpl;
//@CrossOrigin("http://localhost:4200/homepage")
@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
public class ApiController {

	@Autowired
	private LoanServiceImpl loanService;
	
	@Autowired
	private LoanScheduleServices loanscheduleservices;
	
	@GetMapping("/customerloans")
	public List<LoanEntity>list(){
		return loanService.printloan(); 
	}
	@GetMapping("/schedule")
	public List<ScheduleEntity> scheduleList(){
		return loanscheduleservices.listAllSchedule();
	}
	@PostMapping("/createlone")
	public LoanEntity createLone(@RequestBody LoanEntity loanEntity) {
		
		return loanService.saveLone(loanEntity);
		 
	}
}
