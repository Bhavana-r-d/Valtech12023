package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {
	public static void main(String[] args) throws Exception {

		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		AnnotationConfiguration cfg = new AnnotationConfiguration();// select Configuration from (org.hibernate.cfg)
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(TellerTx.class)
				.addAnnotatedClass(AtmTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class).addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class).addAnnotatedClass(BankAccount.class);

		SessionFactory sesFac = cfg.buildSessionFactory();
		Session ses = sesFac.openSession();
		Transaction tx = ses.beginTransaction();
		
		ses.persist(new BankAccount(new BankAccountId("SB",1),30000));
		
		BankAccountId id =new BankAccountId("SB",1);
		BankAccount ba=(BankAccount) ses.load(BankAccount.class, id);

//		Customer cus = new Customer("sonu", 23);
//		ses.save(cus);
//
//		Address add = new Address("JP nagar", "blr", 560078);
//		add.setCustomer(cus);
//		cus.setAddress(add);
//		ses.save(add);

//		Account acc = new Account(1000, "SB");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 123456, 232434);
//		Tx tx3 = new TellerTx(3000, 123, 345);
//		Tx tx4 = new AtmTx(7000, 123);
//
//		Account acc1 = new Account(2000, "CA");
//		Tx tx5 = new ChequeTx(3000, 1234567, 2132434);
//
//		Customer cus1 = new Customer("Def", 25);
//		Address add1 = new Address("Jayanagar", "blr", 560070);
//		Customer cus2 = new Customer("qeqw", 27);
//		Address add2 = new Address("Gandhinagar", "Hyb", 560055);
//
//		ses.persist(acc);
//		ses.persist(tx1);
//		ses.persist(tx2);
//		ses.persist(tx3);
//		ses.persist(tx4);
//
//		ses.persist(acc1);
//		ses.persist(tx5);
//		ses.persist(cus1);
//		ses.persist(cus2);
//		ses.persist(add1);
//		ses.persist(add2);
//
//		cus1.setAddress(add1);
//		add1.setCustomer(cus1);
//		cus2.setAddress(add2);
//		add2.setCustomer(cus2);
//
//		acc.addTxs(tx1);
//		acc.addTxs(tx2);
//		acc.addTxs(tx3);
//		acc.addTxs(tx4);
//    	acc1.addTxs(tx5);
//    	
//    	
//		acc1.addCustomer(cus2);
//		acc1.addCustomer(cus);
//		acc.addCustomer(cus1);
//		acc.addCustomer(cus2);
//		acc.addCustomer(cus);
//
//		ses.save();
//
//		ses.save(new Tx(1000));
//		ses.save(new ChequeTx(2000, 123123, 232323));
//		ses.save(new TellerTx(3000, 123, 678));
//		ses.save(new AtmTx(5000, 345));

//		ses.createQuery("from Tx tx").list().forEach(t -> System.out.println(t));
//		ses.createQuery("Select tx.account From Tx tx").list().forEach(t -> System.out.println(t));// we get dublicate
//																									// acc
//
//		ses.createQuery("Select distinct tx.account From Tx tx").list().forEach(t -> System.out.println(t));// we gwt
//																											// distinct
//																											// transaction
//
//		org.hibernate.Query query = ses
//				.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount>?");
//		query.setFloat(0, 1000);
//		query.list().forEach(t -> System.out.println(t));

		Query query =ses.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
			//	ses.createQuery("SELECT t from Tx t JOIN t.account.customers c  WHERE c.address.city = ? AND t.amount >?");
		query.setString(0, "Blr");
		query.setFloat(1, 1000);
		query.list().forEach(t -> System.out.println(t));
		// ses.persist(new Employee("xyz",LocalDate.of(1947, 8, 15),20000,'F',false));

		/*
		 * int id = (Integer) ses.save(new Employee("xyz", df.parse("15-08-1947"),
		 * 20000,'F', false)); System.out.println(id);
		 */

		/*
		 * Employee e=(Employee)
		 * ses.get(Employee.class,1); //
		 * System.out.println(e.getClass().getName());
		 * e.setName("xyz1");
		 */

		/*
		 * ses.merge(e);
		 */

		System.out.println("Loading......");
		tx.commit();
		ses.close();
		sesFac.close();
	}

}
