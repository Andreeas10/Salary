package salariu.controllers;

import salariu.builders.IEmployeeBuilder;
import salariu.builders.ISalaryBuilder;
import salariu.builders.NetSalaryBuilder;
import salariu.model.IEmployee;
import salariu.model.ISalary;
import salariu.model.ITax;
import salariu.model.Salary;
import salariu.model.Tax;
import salariu.repositories.IMainRepository;
import salariu.tabels.DisplayTabel;
import salariu.views.UpdateView;

public class UpdateViewController implements IUpdateViewController{
	
	private IMainRepository mainRepository;
	private IEmployee employee;
	private UpdateView updateView;
	private IEmployeeBuilder currentBuilder;
	private ISalaryBuilder netSalaryBuilder;
	private ISalaryBuilder grossSalaryBuilder;
	private ISalaryBuilder currentSalaryBuilder;
	private DisplayTabel displayTabel;

	public UpdateViewController(IMainRepository mainRepository, IEmployee employee,IEmployeeBuilder currentBuilder,
			ISalaryBuilder netSalaryBuilder,ISalaryBuilder grossSalaryBuilder,DisplayTabel displayTabel 
			) {
		// TODO Auto-generated constructor stub
		this.mainRepository = mainRepository;
		this.employee = employee;
		this.currentBuilder = currentBuilder;
		this.netSalaryBuilder = netSalaryBuilder;
		this.grossSalaryBuilder = grossSalaryBuilder;
		currentSalaryBuilder = netSalaryBuilder;
		this.displayTabel = displayTabel;
	}

	@Override
	public void setUpdateView(UpdateView updateView) {
		// TODO Auto-generated method stub
		this.updateView = updateView;
		
	}

	@Override
	public void setEmployeeField() {
		// TODO Auto-generated method stub
		updateView.setNameField(employee.getName());
		
	}

	@Override
	public void save(Double grossSalary) {
		// TODO Auto-generated method stub
		ISalary salary;
		if (currentSalaryBuilder.equals(netSalaryBuilder))
			salary = currentBuilder.buildSalaryWithNetSalary(updateView.getSalary(),mainRepository);
		else
			salary = currentBuilder.buildSalaryWithGrossSalary(updateView.getSalary(),mainRepository);
		employee.setSalary(salary);
		
		
		employee.setTax(currentBuilder.buildTax(salary, mainRepository.getTaxRepository()));
		displayTabel.updateModel();
		
		
	}

	@Override
	public void changeToNetSalaryBuilder() {
		currentSalaryBuilder = netSalaryBuilder;
		
	}

	@Override
	public void changeToGrossSalaryBuilder() {
		currentSalaryBuilder = grossSalaryBuilder;
		
		
	}
	
	
	
	

}
