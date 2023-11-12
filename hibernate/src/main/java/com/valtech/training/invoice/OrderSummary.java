
package com.valtech.training.invoice;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.valtech.training.hibernate.OrderSummaryId;

@Entity
@Table(name = "OrderSummary")
@IdClass(OrderSummaryId.class)
public class OrderSummary {

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private OrderSummaryId id;
	
	private int productQuantity;
	
	

	public OrderSummary() {
	}
	
	

	public OrderSummary(OrderSummaryId id, int productQuantity) {
		this.id = id;
		this.productQuantity = productQuantity;
	}



	public OrderSummaryId getId() {
		return id;
	}

	public void setId(OrderSummaryId id) {
		this.id = id;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	

}
