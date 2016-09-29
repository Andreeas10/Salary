package salariu.model;

import java.io.Serializable;

import salariu.repositories.ITaxRepository;

public interface ITax extends Serializable{
	
	public double getCAS1();

	public double getCAS2();
	
	public double getCASS1();
	
	public double getCASS2();
	
	public double getCFS1();
	
	public double getCFS2();
	
	public double getIV1();
	
	public double getCCI2();
	
	public double getFGPCS2();
	
	public double getAMBP2();
	
	public double getTotalTaxWithoutIV1();
	
	public double getTotalTax1();
	
	public double getTotalTax2();

	
	
	
	

}
