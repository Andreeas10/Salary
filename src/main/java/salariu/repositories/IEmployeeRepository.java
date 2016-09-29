package salariu.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import salariu.exception.EmployeeNotFoundException;

import salariu.model.IEmployee;

public interface IEmployeeRepository extends Serializable{

	public List<IEmployee> getListEmployee();

	public void setListEmployee(List<IEmployee> listEmployee);
	
	public List<IEmployee> getEmployeeList();
	
	public void addEmployee(IEmployee employee);

	public void adaugareinlista(IEmployee employeeAdded);

	public IEmployee findBySsn(String employeeSsn)throws EmployeeNotFoundException;

}
