package salariu.repositories;

import java.util.ArrayList;
import java.util.List;

import salariu.exception.EmployeeNotFoundException;

import salariu.model.IEmployee;

public class EmployeeRepository implements IEmployeeRepository {

	private List<IEmployee> listEmployee;

	public EmployeeRepository(){
		listEmployee = new ArrayList<>();
	}
	public List<IEmployee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<IEmployee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	@Override
	public void addEmployee(IEmployee employee) {
		listEmployee.add(employee);
		
	}
	@Override
	public void adaugareinlista(IEmployee employeeAdded) {
		listEmployee.add(employeeAdded);
		
	}
	

	public IEmployee findBySsn(String ssn) throws EmployeeNotFoundException{
		for (IEmployee employee : listEmployee) {
			if(employee.hasSsn(ssn)){
				return employee;
			}
		}
		
		throw new EmployeeNotFoundException();
	}
	@Override
	public List<IEmployee> getEmployeeList() {
		
		return listEmployee;
	}
}
