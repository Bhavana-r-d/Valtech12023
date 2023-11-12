package com.valtech.training.invoice;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private  String productName;
private float productAmount;



@ManyToOne(targetEntity = Company.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH }, fetch = FetchType.EAGER)
@JoinColumn(name="manufactureId",referencedColumnName = "companyId")
private Company company;

public Product(String productName, float productAmount) {

	this.productName = productName;
	this.productAmount = productAmount;
}
public Product(int productId, String productName, float productAmount) {

	this.productId = productId;
	this.productName = productName;
	this.productAmount = productAmount;
}
public Product() {
	
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public float getProductAmount() {
	return productAmount;
}
public void setProductAmount(float productAmount) {
	this.productAmount = productAmount;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}


}
