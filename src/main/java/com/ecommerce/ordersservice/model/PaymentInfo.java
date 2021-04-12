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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "paymentInfo")

public class PaymentInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="payments_info_seq_gen")
	@SequenceGenerator(name="payments_info_seq_gen", sequenceName="payments_info_SEQ")
	private long paymentInfoId;
	
	@Column(name = "card_type")
	private String cardType;
	@Column(name = "card_number")
	private String cardNumber;
	
	@Column(name = "name_on_card")
	private String nameOnCard;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "cvv")
	private String cvv;
	
	@Column(name = "billing_address")
	private long billingAddressId;
	

	public PaymentInfo() {
		super();
	}

	
	


	public PaymentInfo(long paymentInfoId, String cardType, String cardNumber, String nameOnCard, Date expiryDate,
			String cvv, long billingAddressId) {
		super();
		this.paymentInfoId = paymentInfoId;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.nameOnCard = nameOnCard;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
		this.billingAddressId = billingAddressId;
	}


	public long getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(long paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	
}
