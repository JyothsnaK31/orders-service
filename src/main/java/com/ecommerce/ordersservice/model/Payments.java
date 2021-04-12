package com.ecommerce.ordersservice.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "payments")
public class Payments {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="payments_seq_gen")
	@SequenceGenerator(name="payments_seq_gen", sequenceName="payments_SEQ")
	private long paymentId;

	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "payment_date")
	private Date PaymentDate;
	
	@Column(name = "confirmation_number")
	private String confirmationNumber;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@OneToOne(targetEntity = PaymentInfo.class, cascade = CascadeType.PERSIST)
	    private PaymentInfo paymentInformation;

	public PaymentInfo getPaymentInformation() {
		return paymentInformation;
	}


	public void setPaymentInformation(PaymentInfo paymentInformation) {
		this.paymentInformation = paymentInformation;
	}


	public Payments() {
		super();
	}
	

	public Payments(long paymentId, String paymentMethod, Date paymentDate, String confirmationNumber,
			BigDecimal amount) {
		super();
		this.paymentId = paymentId;
		this.paymentMethod = paymentMethod;
		PaymentDate = paymentDate;
		this.confirmationNumber = confirmationNumber;
		this.amount = amount;
	}




	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
		
}
