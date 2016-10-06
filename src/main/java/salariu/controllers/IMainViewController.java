package salariu.controllers;

import salariu.views.MainView;

public interface IMainViewController {
	
	public void openAddViewController();
	public void removeEmployee(String ssn);
	public void updateEmployee(String ssn);
	public void searchViewDetailsController(String ssn);
	public void setMainView(MainView mainView);
	public void showEmployeeTabel();
	public void serializedata();
	public void adjustTaxes();
	

}
