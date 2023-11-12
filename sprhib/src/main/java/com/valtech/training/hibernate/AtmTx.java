package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class AtmTx extends Tx {

	private int atm;
	

	public AtmTx() {

	}

	public AtmTx(int atm,float amount) {
		super(amount);
		this.atm=atm;
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}

}
