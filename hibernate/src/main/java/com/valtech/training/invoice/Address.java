package com.valtech.training.invoice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private int zipCode;
	
	
	@OneToOne(targetEntity = Company.class, cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY,mappedBy = "address")
	private Company company;

	
	@OneToOne(targetEntity = Customer.class, cascade = { CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY,mappedBy = "address")
	private Customer customer;
	
	
	
	public Address(String street, String city, int zipCode, Company company, Customer customer) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.company = company;
		this.customer = customer;
	}

	public Address(String street, String city, int zipCode) {

		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}

	public Address() {

	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
