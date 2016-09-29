package salariu.controllers;

import salariu.views.AddView;

public interface IAddViewController {

	void setAddView(AddView addView);

	void addEmployee();


	void changeToNetSalaryBuilder();

	void changeToGrossSalaryBuilder();

	void changeToSellerEmployeeBuilder();
	
	void changeToProgrammerEmployeeBuilder();
	
	void changeToDisabledEmployeeBuilder();

	void changeToSampleEmployeeBuilder(); 
	


}
