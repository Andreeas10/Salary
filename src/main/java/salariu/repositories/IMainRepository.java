package salariu.repositories;

import java.io.Serializable;

public interface IMainRepository extends Serializable{
	
	public IEmployeeRepository getEmployeeRepository();
	
	public ITaxRepository getTaxRepository();

	public double getSalesPercentage();

}
