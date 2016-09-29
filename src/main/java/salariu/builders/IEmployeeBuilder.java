package salariu.builders;

import java.io.Serializable;

import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;

public interface IEmployeeBuilder extends Serializable  {

	IEmployee build(String employeeSsn, String employeeName, ISalary salary);

	ITax buildTax(ISalary salary, ITaxRepository taxRepository);
	
	ISalary buildSalaryWithGrossSalary(double grossSalary,IMainRepository mainRepository);
	
	ISalary buildSalaryWithNetSalary(double netSalary, IMainRepository mainRepository);
	

	
	

}
