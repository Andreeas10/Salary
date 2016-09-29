package salariu.builders;

import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.model.Salary;
import salariu.model.Tax;
import salariu.model.TaxDisabled;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;
import salariu.repositories.MainRepository;

public class DisabledEmployeeBuilder implements IEmployeeBuilder {

	private IEmployeeBuilder employeeBuilder;

	public DisabledEmployeeBuilder(IEmployeeBuilder employeeBuilder) {
		super();
		this.employeeBuilder = employeeBuilder;
	}

	@Override
	public IEmployee build(String employeeSsn, String employeeName, ISalary salary) {
		// TODO Auto-generated method stub
		IEmployee employee = employeeBuilder.build(employeeSsn, employeeName, salary);

		employee.setType("Disabled");

		return employee;
	}

	@Override
	public ITax buildTax(ISalary salary, ITaxRepository taxRepository) {
		// TODO Auto-generated method stub
		ITax tax = new Tax(salary.getGrossSalary(), taxRepository);

		return new TaxDisabled(tax);
	}

	@Override
	public ISalary buildSalaryWithGrossSalary(double grossSalary, IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		return new Salary(grossSalary * taxRepository.getTaxPercentForDisabled(), grossSalary);
	}

	@Override
	public ISalary buildSalaryWithNetSalary(double netSalary, IMainRepository mainRepository) {
		// TODO Auto-generated method stub
		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		return new Salary(netSalary, netSalary / taxRepository.getTaxPercentForDisabled());
	}

}
