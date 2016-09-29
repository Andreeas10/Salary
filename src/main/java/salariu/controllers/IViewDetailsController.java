package salariu.controllers;

import salariu.views.ViewDetails;


public interface IViewDetailsController {

	void setViewDetails(ViewDetails viewDetails);
	
	void populateFieldsViewDetails();

	int getProgressBarValue();

	double getNetSalary();

	double getTotal();

}
