package salariu.controllers;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import salariu.builders.DisabledEmployeeBuilder;
import salariu.builders.EmployeeBuilder;
import salariu.builders.GrossSalaryBuilder;
import salariu.builders.IEmployeeBuilder;
import salariu.builders.ISalaryBuilder;
import salariu.builders.NetSalaryBuilder;
import salariu.builders.ProgrammerEmployeeBuilder;
import salariu.builders.SampleEmployeeBuilder;
import salariu.builders.SellerEmployeeBuilder;
import salariu.exception.EmployeeNotFoundException;
import salariu.model.IEmployee;
import salariu.repositories.IEmployeeRepository;
import salariu.repositories.IMainRepository;
import salariu.repositories.RepositorySerializator;
import salariu.tabels.DisplayTabel;
import salariu.views.AddView;
import salariu.views.MainView;
import salariu.views.UpdateView;
import salariu.views.ViewDetails;

public class MainViewController implements IMainViewController {

	private IMainRepository mainRepository;
	private MainView mainView;
	private RepositorySerializator repositorySerializator;
	private DisplayTabel displayTabel;

	public MainViewController(IMainRepository mainRepository, RepositorySerializator repositorySerializator) {
		displayTabel = new DisplayTabel(mainRepository);
		this.mainRepository = mainRepository;
		this.repositorySerializator = repositorySerializator;

	}

	@Override
	public void openAddViewController() {
		
		
		
		ISalaryBuilder netSalaryBuilder = new NetSalaryBuilder();
		ISalaryBuilder grossSalaryBuilder = new GrossSalaryBuilder();

		IEmployeeBuilder employeeBuilder = new EmployeeBuilder();

		IEmployeeBuilder sample = new SampleEmployeeBuilder(employeeBuilder);
		IEmployeeBuilder programmer = new ProgrammerEmployeeBuilder(employeeBuilder);
		IEmployeeBuilder disabled = new DisabledEmployeeBuilder(employeeBuilder);
		/*
		 * IEmployeeBuilder seller = new SellerEmployeeBuilder(0,
		 * employeeBuilder, mainRepository);
		 */

		IAddViewController addViewController = new AddViewController(mainRepository, programmer, sample, disabled,
				netSalaryBuilder, netSalaryBuilder, grossSalaryBuilder,displayTabel);
		AddView addView = new AddView(addViewController);
		addViewController.setAddView(addView);
		addView.setVisible(true);
		

	}

	@Override
	public void searchViewDetailsController(String ssn) {

		try {
			IEmployee copie = mainRepository.getEmployeeRepository().findBySsn(ssn);
			// fillAllEmployeeField(copie);
			// viewEmployee.setCAS(copie.getSalary());
			IViewDetailsController viewDetailsController = new ViewDetailsController(mainRepository, copie);
			ViewDetails viewDetails = new ViewDetails(viewDetailsController);
			viewDetailsController.setViewDetails(viewDetails);
			viewDetailsController.populateFieldsViewDetails();
			viewDetails.setVisible(true);
		} catch (EmployeeNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Employee doesn't exist!");

		}

	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;

	}

	@Override
	public void showEmployeeTabel() {
		displayTabel.setVisible(true);

	}

	@Override
	public void serializedata() {

		try {
			repositorySerializator.serialize(mainRepository);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removeEmployee(String ssn) {
		// TODO Auto-generated method stub

		try {
			IEmployee copie = mainRepository.getEmployeeRepository().findBySsn(ssn);

			mainRepository.getEmployeeRepository().getListEmployee().remove(copie);
			displayTabel.updateModel();
			JOptionPane.showMessageDialog(null, "Employee with ssn: "+copie.getSsn()+"  was removed!");

		} catch (EmployeeNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Employee doesn't exist!");

		}

	}

	@Override
	public void updateEmployee(String ssn) {
		// TODO Auto-generated method stub
		try {
			ISalaryBuilder netSalaryBuilder = new NetSalaryBuilder();
			ISalaryBuilder grossSalaryBuilder = new GrossSalaryBuilder();

			IEmployee copie = mainRepository.getEmployeeRepository().findBySsn(ssn);

			IUpdateViewController updateViewController = new UpdateViewController(mainRepository, copie,
					copie.getCurrentBuilder(), netSalaryBuilder, grossSalaryBuilder,displayTabel);
			UpdateView updateView = new UpdateView(updateViewController);
			updateViewController.setUpdateView(updateView);
			updateViewController.setEmployeeField();
			updateView.setVisible(true);
			

		} catch (EmployeeNotFoundException e) {

			JOptionPane.showMessageDialog(null, "Employee doesn't exist!");

		}

	}

	@Override
	public void adjustTaxes() {
		// TODO Auto-generated method stub
		
		
	}

}
