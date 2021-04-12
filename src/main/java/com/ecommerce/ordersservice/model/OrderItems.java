package com.ecommerce.ordersservice.model;

import java.util.List;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="order_items_seq_gen")
	@SequenceGenerator(name="order_items_seq_gen", sequenceName="order_items_SEQ")
	private long Id;
	
	
	@Column(name = "item_quantity")
	private int itemQuantity;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "order_id") private Orders order;
	 */
	
	
	/*
	 * @ManyToOne(targetEntity = Items.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name ="item_no",referencedColumnName = "ItemNo") private Items
	 * item;
	 */

	
	  @ManyToOne
	  @JoinColumn(name = "item_id") 
	  private Items item;
	 
	
	
	


	public OrderItems() {
		super();
	}


	public OrderItems(long id, int itemQuantity, Items item) {
		super();
		Id = id;
		this.itemQuantity = itemQuantity;
		this.item = item;
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public int getItemQuantity() {
		return itemQuantity;
	}


	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	public Items getItem() {
		return item;
	}


	public void setItem(Items item) {
		this.item = item;
	}
	
	
	
	
	

}
