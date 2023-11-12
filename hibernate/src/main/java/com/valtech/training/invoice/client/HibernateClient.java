package com.valtech.training.invoice.client;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.OrderSummary;
import com.valtech.training.hibernate.OrderSummaryId;
import com.valtech.training.invoice.Address;
import com.valtech.training.invoice.Company;
import com.valtech.training.invoice.Customer;
import com.valtech.training.invoice.Order;
import com.valtech.training.invoice.Product;

public class HibernateClient {
	public static void main(String[] args) throws ParseException {
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		AnnotationConfiguration cfg =new AnnotationConfiguration();
		cfg.addAnnotatedClass(Company.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Product.class);
	    cfg.addAnnotatedClass(Order.class);
	    cfg.addAnnotatedClass(OrderSummaryId.class);
	    cfg.addAnnotatedClass(OrderSummary.class);
	    
		 
		
		
		SessionFactory sesFac =cfg.buildSessionFactory();
		Session ses=sesFac.openSession();
		Transaction tx=ses.beginTransaction();
		
		Company company=new Company("Valtech");
		Customer customer=new Customer("Krisha",990088112);
		Address address=new Address("JP nagar","Bengaluru",580023);
		Product product= new Product("Ipod",30000); 
		
		
		Order order=new Order(df.parse("15-02-2023"));
		order.setCustomer(customer);
		
	
	    
	    
	    OrderSummary orderSummary=new OrderSummary();
	    ses.save(orderSummary);
		
		
		
		
        company.setAddress(address);
		customer.setAddress(address);
		address.setCustomer(customer);
		customer.setAddress(address);
		address.setCompany(company);
		company.setAddress(address);
		product.setCompany(company);
	
		
		 ses.persist(company);
	     ses.persist(customer);
		 ses.persist(address);
		 ses.persist(product);
         ses.persist(order);
		 
		 
		 
		System.out.println("loading");
		tx.commit();
		ses.close();
		sesFac.close();
		
	}

}
