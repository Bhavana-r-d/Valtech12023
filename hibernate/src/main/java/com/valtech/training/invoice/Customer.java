package com.valtech.training.invoice;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private long phoneNo;
	
	@OneToOne(targetEntity = Address.class,cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name="addressId",referencedColumnName = "id")
	private Address address;
	
	@OneToMany(targetEntity=Order.class,cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER,mappedBy="customer")
	private Set<Order> order;

	public Customer() {

	}

	public Customer(String customerName, long phoneNo) {

		this.customerName = customerName;
		
		this.phoneNo = phoneNo;
	}

	
	
	public Customer(String customerName, long phoneNo, Address address) {
	
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}
}
