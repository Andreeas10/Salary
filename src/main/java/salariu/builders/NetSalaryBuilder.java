package salariu.builders;

import salariu.model.ISalary;
import salariu.model.Salary;

public class NetSalaryBuilder implements ISalaryBuilder {

	@Override
	public ISalary build(double netSalary) {
		return new Salary(netSalary, 0);
	}



}
