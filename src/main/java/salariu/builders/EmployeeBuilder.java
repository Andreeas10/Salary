package salariu.builders;

import salariu.model.Employee;
import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;

public class EmployeeBuilder implements IEmployeeBuilder{

	@Override
	public IEmployee build(String employeeSsn, String employeeName, ISalary salary) {
		return new Employee(employeeSsn,employeeName,salary);
	}

	

	@Override
	public ITax buildTax(ISalary salary, ITaxRepository taxRepository) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ISalary buildSalaryWithGrossSalary(double grossSalary,IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ISalary buildSalaryWithNetSalary(double netSalary,IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		return null;
	}



	




}
