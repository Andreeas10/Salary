package salariu.model;

import java.io.Serializable;

public interface ISalary extends Serializable{
	
	public double getGrossSalary();
	public void setGrossSalary(double grossSalary);
	public double getNetSalary();
	public void setNetSalary(double netSalary);
	

}
