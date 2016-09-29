package salariu.builders;

import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.model.Salary;
import salariu.model.Tax;
import salariu.model.TaxSample;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;

public class SampleEmployeeBuilder implements IEmployeeBuilder {

	private IEmployeeBuilder employeeBuilder;

	public SampleEmployeeBuilder(IEmployeeBuilder employeeBuilder) {
		super();
		this.employeeBuilder = employeeBuilder;

	}

	@Override
	public IEmployee build(String employeeSsn, String employeeName, ISalary salary) {
		// ITax tax = new NonTax();
		// ITax tax = new BasicTax();
		IEmployee employee = employeeBuilder.build(employeeSsn, employeeName, salary);
		employee.setType("Sample");
		return employee;
	}

	@Override
	public ITax buildTax(ISalary salary, ITaxRepository taxRepository) {

		ITax tax = new Tax(salary.getGrossSalary(), taxRepository);
		return new TaxSample(tax);
	}

	@Override
	public ISalary buildSalaryWithGrossSalary(double grossSalary, IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		return new Salary(grossSalary * taxRepository.getTaxPercentForSample(), grossSalary);
	}

	@Override
	public ISalary buildSalaryWithNetSalary(double netSalary, IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		return new Salary(netSalary, netSalary / taxRepository.getTaxPercentForSample());
	}

}
