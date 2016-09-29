package salariu.controllers;

import salariu.model.IEmployee;
import salariu.repositories.IEmployeeRepository;
import salariu.repositories.IMainRepository;
import salariu.views.ViewDetails;

public class ViewDetailsController implements IViewDetailsController {

	private IMainRepository mainRepository;
	private ViewDetails viewDetails;
	private IEmployee employee;

	public ViewDetailsController(IMainRepository mainRepository, IEmployee employee) {
		this.mainRepository = mainRepository;
		this.employee = employee;

	}

	@Override
	public void setViewDetails(ViewDetails viewDetails) {
		this.viewDetails = viewDetails;

	}

	@Override
	public void populateFieldsViewDetails() {
		viewDetails.setCAS1(employee.getTax().getCAS1());
		viewDetails.setCAS2(employee.getTax().getCAS2());
		viewDetails.setCASS1(employee.getTax().getCASS1());
		viewDetails.setCASS2(employee.getTax().getCASS2());
		viewDetails.setCFS1(employee.getTax().getCFS1());
		viewDetails.setCFS2(employee.getTax().getCFS2());
		viewDetails.setIV1(employee.getTax().getIV1());
		viewDetails.setCCI2(employee.getTax().getCCI2());
		viewDetails.setFGPCS2(employee.getTax().getFGPCS2());
		viewDetails.setAMBP2(employee.getTax().getAMBP2());
		viewDetails.setTotalTax1(employee.getTax().getTotalTax1());
		viewDetails.setTotalTax2(employee.getTax().getTotalTax2());
		viewDetails.setNetSalary(employee.getEmployeeNetSalary());
		viewDetails.setGrossSalary(employee.getEmployeeGrossSalary());
		viewDetails.setTotalFees(employee.getTax().getTotalTax1() + employee.getTax().getTotalTax2());

	}

	@Override
	public int getProgressBarValue() {
		// TODO Auto-generated method stub
		double total, procent;
		total = employee.getEmployeeGrossSalary() + employee.getTax().getTotalTax2();
		procent = (100 * employee.getEmployeeNetSalary()) / total;
		
		return (int) procent;
	}

	@Override
	public double getNetSalary() {
		// TODO Auto-generated method stub
		return employee.getEmployeeNetSalary();
	}



	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return employee.getTax().getTotalTax2()+employee.getEmployeeGrossSalary();
	}
}