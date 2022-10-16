package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LoanEntity;
import com.example.demo.Entity.ScheduleEntity;
import com.example.demo.Entity.Status;
import com.example.demo.repository.ScheduleRepo;

@Service
public class LoanScheduleServices {
	
	@Autowired
	private ScheduleRepo scheduleRepo;
	
	public List<ScheduleEntity> listAllSchedule(){
		return scheduleRepo.findAll();
	}
	 
	public List<ScheduleEntity> saveSchedule(LoanEntity loanEntity){
		
		String paymentTerm="EVEN";
		List<ScheduleEntity> scheduleList=new ArrayList<>();
		if(paymentTerm.equalsIgnoreCase(loanEntity.getPaymentTerm())) {
			scheduleList=evenPrincipleLoan(loanEntity);
		}else {
			scheduleList=interestPrincipleLoan(loanEntity);
		}
		return scheduleList;
	}
	
	public List<ScheduleEntity> evenPrincipleLoan(LoanEntity loanEntity) {
		ArrayList<ScheduleEntity> scheduleList = new ArrayList<>();
		int numberOfInstallments=(loanEntity.getTenure()*loanEntity.getPaymentFrequency());

		
		double principle =(loanEntity.getLoanAmount()/loanEntity.getPaymentFrequency());		
		
		for(int i=0;i<numberOfInstallments;i++) {
			
			double interest=((loanEntity.getLoanAmount()-(principle*(i)))*loanEntity.getInterestRate()*loanEntity.getTenure())/(100*loanEntity.getPaymentFrequency());

			ScheduleEntity scheduleEntity = new ScheduleEntity();
			scheduleEntity.setPaymentDate(loanEntity.getLoanStartDate().plusMonths(12/loanEntity.getPaymentFrequency()));
			scheduleEntity.setProjectedIntrest(interest);
			scheduleEntity.setPrincipal(principle);
			scheduleEntity.setPaymentAmount(interest+principle);
			scheduleEntity.setStatus(Status.Projected);
			scheduleRepo.save(scheduleEntity);
			scheduleList.add(scheduleEntity);
		}
		
		return scheduleList;
		
	}                                                                                                                    
	
	public List<ScheduleEntity> interestPrincipleLoan(LoanEntity loanEntity){
		
		List<ScheduleEntity>scheduleList = new ArrayList<ScheduleEntity>(); 
		
		int numberOfInstallments=(loanEntity.getTenure()*loanEntity.getPaymentFrequency());


		double principle =(loanEntity.getLoanAmount()/loanEntity.getPaymentFrequency());
        double interest=((loanEntity.getLoanAmount()*loanEntity.getInterestRate()*loanEntity.getTenure())/(100*numberOfInstallments));
		
		

			for (int i=0;i<numberOfInstallments;i++)
			{
				
				if(i==numberOfInstallments-1) {
				
					ScheduleEntity scheduleEntity =new ScheduleEntity();
					scheduleEntity.setPaymentDate(loanEntity.getLoanStartDate().plusMonths(12/loanEntity.getPaymentFrequency()));
					scheduleEntity.setPrincipal(0);
					scheduleEntity.setProjectedIntrest(interest);
					scheduleEntity.setStatus(Status.Projected);
					scheduleEntity.setPaymentAmount(interest+loanEntity.getLoanAmount());
					scheduleRepo.save(scheduleEntity);
					scheduleList.add(scheduleEntity);
					//scheduleEntity.setPaymentDate(scheduleEntity.setPaymentDate(loanEntity.getLoanStartDate().plusMonths(loanEntity.getPaymentFrequency())));
					
				}else{
					ScheduleEntity scheduleEntity =new ScheduleEntity();
					scheduleEntity.setPaymentDate(loanEntity.getLoanStartDate().plusMonths(12/loanEntity.getPaymentFrequency()));
					scheduleEntity.setPrincipal(0);
					scheduleEntity.setProjectedIntrest(interest);
					scheduleEntity.setStatus(Status.Projected);
					scheduleEntity.setPaymentAmount(interest);
					scheduleRepo.save(scheduleEntity);
					scheduleList.add(scheduleEntity);
				}
				
				}
				
								
			
		return scheduleList;
	}
	

}
