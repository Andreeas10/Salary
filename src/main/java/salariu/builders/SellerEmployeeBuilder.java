package salariu.builders;

import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.model.Salary;
import salariu.model.Tax;
import salariu.model.TaxSeller;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;

public class SellerEmployeeBuilder implements IEmployeeBuilder {

	private double salesMoney;

	private IEmployeeBuilder employeeBuilder;

	private IMainRepository repository;

	public SellerEmployeeBuilder(double salesMoney, IEmployeeBuilder employeeBuilder, IMainRepository repository) {
		super();
		this.salesMoney = salesMoney;
		this.employeeBuilder = employeeBuilder;
		this.repository = repository;
	}

	@Override
	public IEmployee build(String employeeSsn, String employeeName, ISalary salary) {

		IEmployee employee = employeeBuilder.build(employeeSsn, employeeName, salary);
		employee.setType("Seller");
		return employee;
	}

	@Override
	public ITax buildTax(ISalary salary, ITaxRepository taxRepository) {
		// TODO Auto-generated method stub
		ITax tax = new Tax(salary.getGrossSalary() + repository.getSalesPercentage(), taxRepository);
		return new TaxSeller(tax);
	}

	@Override
	public ISalary buildSalaryWithGrossSalary(double grossSalary, IMainRepository mainRepository) {

		// TODO Auto-generated method stub

		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		grossSalary = grossSalary + (salesMoney * repository.getSalesPercentage());

		return new Salary(grossSalary * taxRepository.getTaxPercentForSample(), grossSalary);

	}

	@Override
	public ISalary buildSalaryWithNetSalary(double netSalary, IMainRepository mainRepository) {
		// TODO Auto-generated method stub

		ITaxRepository taxRepository = mainRepository.getTaxRepository();

		netSalary = netSalary + (salesMoney * repository.getSalesPercentage()) * taxRepository.getTaxPercentForSample();

		return new Salary(netSalary, netSalary / taxRepository.getTaxPercentForSample());
	}

}
