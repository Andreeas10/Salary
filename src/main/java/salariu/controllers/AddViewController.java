package salariu.controllers;

import salariu.builders.EmployeeBuilder;
import salariu.builders.IEmployeeBuilder;
import salariu.builders.ISalaryBuilder;
import salariu.builders.SellerEmployeeBuilder;
import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.repositories.IEmployeeRepository;
import salariu.repositories.IMainRepository;
import salariu.tabels.DisplayTabel;
import salariu.views.AddView;

public class AddViewController implements IAddViewController {

	private IMainRepository mainRepository;
	private IEmployeeRepository employeeRepository;

	private AddView addView;

	
	private IEmployeeBuilder programmer;
	private IEmployeeBuilder sample;
	private IEmployeeBuilder disabled;
	private IEmployeeBuilder currentBuilder;

	private ISalaryBuilder netSalaryBuilder;
	private ISalaryBuilder grossSalaryBuilder;

	private ISalaryBuilder salaryBuilder;
	
	private DisplayTabel displayTabel;


	public AddViewController(IMainRepository mainRepository, IEmployeeBuilder programmer, IEmployeeBuilder sample,
			IEmployeeBuilder disabled, ISalaryBuilder salaryBuilder, ISalaryBuilder netSalaryBuilder,
			ISalaryBuilder grossSalaryBuilder, DisplayTabel displayTabel) {
		super();
		this.mainRepository = mainRepository;

		this.salaryBuilder = netSalaryBuilder;
		this.netSalaryBuilder = netSalaryBuilder;
		this.grossSalaryBuilder = grossSalaryBuilder;

		this.currentBuilder = sample;

		this.sample = sample;
		this.programmer = programmer;
		this.disabled = disabled;
		this.employeeRepository = mainRepository.getEmployeeRepository();
		
		this.displayTabel = displayTabel;
	}

	@Override
	public void setAddView(AddView addView) {
		this.addView = addView;

	}

	@Override
	public void addEmployee() {

		 ISalary salary /*= salaryBuilder.build(addView.getSalary())*/; 

		if (salaryBuilder.equals(netSalaryBuilder))
			salary = currentBuilder.buildSalaryWithNetSalary(addView.getSalary(),mainRepository);
		else
			salary = currentBuilder.buildSalaryWithGrossSalary(addView.getSalary(),mainRepository);
		IEmployee employee = currentBuilder.build(addView.getEmployeeSsn(), addView.getEmployeeName(), salary);

		employeeRepository.addEmployee(employee);

		employee.setTax(currentBuilder.buildTax(salary, mainRepository.getTaxRepository()));
		
		employee.setCurrentBuilder(currentBuilder);
		
		displayTabel.updateModel();

		

	}

	@Override
	public void changeToNetSalaryBuilder() {
		salaryBuilder = netSalaryBuilder;

	}

	@Override
	public void changeToGrossSalaryBuilder() {
		salaryBuilder = grossSalaryBuilder;

	}

	@Override
	public void changeToSellerEmployeeBuilder() {
		IEmployeeBuilder employeeBuilder = new EmployeeBuilder();
		currentBuilder = new SellerEmployeeBuilder(addView.getSales(), employeeBuilder, mainRepository);

	}

	@Override
	public void changeToProgrammerEmployeeBuilder() {
		currentBuilder = programmer;

	}

	@Override
	public void changeToDisabledEmployeeBuilder() {
		currentBuilder = disabled;

	}

	@Override
	public void changeToSampleEmployeeBuilder() {
		currentBuilder = sample;

	}

}
