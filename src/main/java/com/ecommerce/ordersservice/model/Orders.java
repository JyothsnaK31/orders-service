package com.ecommerce.ordersservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="orders_seq_gen")
	@SequenceGenerator(name="orders_seq_gen", sequenceName="orders_SEQ")
	private long orderId;

	@Column(name = "customer_id")
	private long orderCustomerId;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@Column(name = "subtotal")
	private BigDecimal subTotal;
	
	@Column(name = "tax")
	private BigDecimal tax;
	
	@Column(name = "shipping_charges")
	private BigDecimal	shippingCharges;
	
	@Column(name = "total")
	private BigDecimal total;
	
	@OneToMany(targetEntity = Payments.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="op_fk",referencedColumnName = "orderId")
	private List<Payments> payments;
	
	//@OneToMany(targetEntity = OrderItems.class,cascade = CascadeType.ALL, mappedBy = "order")
	@OneToMany(targetEntity = OrderItems.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="order_id",referencedColumnName = "orderId")
	private List<OrderItems> orderItems;

	public Orders() {
		super();
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public Orders(long orderId, long orderCustomerId, String orderStatus, Date createdDate, Date modifiedDate,
			BigDecimal subTotal, BigDecimal tax, BigDecimal shippingCharges, BigDecimal total) {
		super();
		this.orderId = orderId;
		this.orderCustomerId = orderCustomerId;
		this.orderStatus = orderStatus;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.subTotal = subTotal;
		this.tax = tax;
		this.shippingCharges = shippingCharges;
		this.total = total;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(long orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(BigDecimal shippingCharges) {
		this.shippingCharges = shippingCharges;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}

	
	}
