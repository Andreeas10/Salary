package salariu.model;

import salariu.builders.IEmployeeBuilder;

public class Employee  implements IEmployee{
	
	private String ssn;
	private String name;
	private ITax tax;
	private ISalary salary;
	private String type;
	private IEmployeeBuilder currentBuilder;
	
	public Employee(String ssn, String name,  ISalary salary) {
		super();
		this.ssn = ssn;
		this.name = name;
		
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", name=" + name + ", tax=" + tax + ", salary=" + salary + "]";
	}
	@Override
	public String getSsn() {
		return ssn;
	}
	@Override
	public void setSsn(String ssn) {
		this.ssn = ssn;  
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
		
	}
	@Override
	public double getEmployeeGrossSalary() {
		// TODO Auto-generated method stub
		return this.salary.getGrossSalary();
	}
	@Override
	public double getEmployeeNetSalary() {
		// TODO Auto-generated method stub
		return this.salary.getNetSalary();
	}
	@Override
	public boolean hasSsn(String ssn) {
		// TODO Auto-generated method stub
		return this.ssn.equals(ssn);
	}
	@Override
	public ITax getTax() {
		// TODO Auto-generated method stub
		return this.tax;
	}
	@Override
	public ISalary getSalary() {
		// TODO Auto-generated method stub
		return this.salary;
	}
	@Override
	public void setTax(ITax buildTax) {
		this.tax = buildTax;
		
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public void setSalary(ISalary salary) {
		this.salary = salary;
		
	}
	@Override
	public void setCurrentBuilder(IEmployeeBuilder currentBuilder) {
		this.currentBuilder = currentBuilder;
		
	}
	@Override
	public IEmployeeBuilder getCurrentBuilder() {
		// TODO Auto-generated method stub
		return currentBuilder;
	}

	

}
