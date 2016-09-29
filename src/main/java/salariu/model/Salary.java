package salariu.model;

public class Salary implements ISalary{

	private double netSalary;
	private double grossSalary;
	
	public Salary(double netSalary,double grossSalary){
		this.netSalary = netSalary;
		this.grossSalary = grossSalary;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

}
