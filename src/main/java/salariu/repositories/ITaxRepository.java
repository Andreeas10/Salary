package salariu.repositories;

import java.io.Serializable;

public interface ITaxRepository extends Serializable{

	public double getPercentOfCAS1();

	public double getPercentOfCAS2();
	
	public double getPercentOfCASS1();
	
	public double getPercentOfCASS2();
	
	public double getPercentOfCFS1();
	
	public double getPrecentOfCFS2();
	
	public double getPercentOfIV1();
	
	public double getPercentOfCCI2();
	
	public double getPercentOfFGPCS2();
	
	public double getPercentOfAMBP2();
	
	public double getTaxPercentForSample();
	
	public double getTaxPercentForProgrammer();
	
	public double getTaxPercentForDisabled();
}
