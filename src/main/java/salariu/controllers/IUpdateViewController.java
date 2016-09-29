package salariu.controllers;

import salariu.views.UpdateView;

public interface IUpdateViewController {

	void setUpdateView(UpdateView updateView);
	void setEmployeeField();
	void save(Double newSalary);
	void changeToNetSalaryBuilder();
	void changeToGrossSalaryBuilder();

}
