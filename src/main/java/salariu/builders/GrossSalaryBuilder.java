package salariu.builders;

import salariu.model.ISalary;
import salariu.model.Salary;

public class GrossSalaryBuilder implements ISalaryBuilder {

	@Override
	public ISalary build(double grossSalary) {
		return new Salary(0,grossSalary);
	}

	/*public double getNetSalaryFromGrossSalary(double grossSalary) {

		return (grossSalary * 7) / 10;
	}*/

}
