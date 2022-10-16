package com.example.demo.Entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PaymentSchedule")
public class ScheduleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int custScheduleId;
	//private int customerId;
	private LocalDate paymentDate;
	private double principal;
	private double projectedIntrest;
	@Enumerated(EnumType.STRING)
	private Status status;
	private double paymentAmount;
	
	

//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	private LoanEntity loanentity;

	public int getCustScheduleId() {
		return custScheduleId;
	}

	public void setCustScheduleId(int custScheduleId) {
		this.custScheduleId = custScheduleId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	
	public double getProjectedIntrest() {
		return projectedIntrest;
	}

	public void setProjectedIntrest(double projectedIntrest) {
		this.projectedIntrest = projectedIntrest;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

//	public LoanEntity getLoanentity() {
//		return loanentity;
//	}
//
//	public void setLoanentity(LoanEntity loanentity) {
//		this.loanentity = loanentity;
//	}

	public ScheduleEntity() {
	//Auto-generated constructor stub
	}

	public ScheduleEntity(int custScheduleId, LocalDate paymentDate, double principal,
			double projectedIntrest, Status status, double paymentAmount) {
		super();
		this.custScheduleId = custScheduleId;
		//this.customerId = customerId;
		this.paymentDate = paymentDate;
		this.principal = principal;
		this.projectedIntrest = projectedIntrest;
		this.status = status;
		this.paymentAmount = paymentAmount;
		//this.loanentity = loanentity;
	}


	
	
	
    

}



//Payment date
//b. Principal (If even principal otherwise 0)
//c. Projected interest
//d. Payment status: (PROJECTED, AWAITINGPAYMENT, PAID). By default
//PROJECTED. On the payment date it should be updated to
//AWAITINGPAYMENT and after payment is made PAID
//e. Payment Amount: