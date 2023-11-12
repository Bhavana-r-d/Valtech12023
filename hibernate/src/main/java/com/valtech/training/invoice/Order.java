package com.valtech.training.invoice;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Basic() @Temporal(TemporalType.DATE)
	private Date orderDate;

	@ManyToOne(targetEntity = Customer.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;

	public Order() {

	}

	public Order(Date orderDate) {

		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
