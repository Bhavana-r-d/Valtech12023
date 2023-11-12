package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
 @Inheritance(strategy = InheritanceType.JOINED) 
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="discriminator")
//if you not provide anything to discriminatorValue defalut it store name of class
//@DiscriminatorValue("tx")
//@Table(name = "alltxs")

@NamedQueries({
	@NamedQuery(name="Tx.findAll",query="SELECT tx from Tx tx"),
	@NamedQuery(name="Tx.findAllByCityAndAmountGreaterThan",query="SELECT tx FROM Tx tx join tx.account.customers c WHERE c.address.city =? AND tx.amount >?")
})

public class Tx {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;

	@ManyToOne(targetEntity = Account.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "Account_id", referencedColumnName = "id")
	private Account account;

	public Tx() {

	}

	public Tx(float amount) {

		this.amount = amount;
	}

	public Tx(int id, float amount) {

		this.id = id;
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	// Generate getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		// return the data
		return ToStringBuilder.reflectionToString(this);
	}

}
