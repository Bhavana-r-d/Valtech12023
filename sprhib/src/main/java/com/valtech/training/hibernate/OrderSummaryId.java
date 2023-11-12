package com.valtech.training.hibernate;

import java.io.Serializable;

import javax.persistence.Id;

public class OrderSummaryId implements Serializable {
	
	private int orderId;
	
	private int itemId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public OrderSummaryId() {
		
	}
	public OrderSummaryId(int orderId, int itemId) {
		
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
	
	

}
