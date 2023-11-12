package com.valtech.training.invoice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderSummaryId implements Serializable {
	@Column(name = "itemId")
	private long itemId;

	@Column(name = "orderId")
	private long orderId;
	
	
	

	public OrderSummaryId() {
	}
	
	

	public OrderSummaryId(long itemId, long orderId) {
		this.itemId = itemId;
		this.orderId = orderId;
	}



	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	
}