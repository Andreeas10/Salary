package salariu.model;

import java.io.Serializable;

import salariu.builders.IEmployeeBuilder;

public interface IEmployee extends Serializable {

	String getSsn();

	void setSsn(String ssn);

	String getName();

	void setName(String name);

	double getEmployeeGrossSalary();

	double getEmployeeNetSalary();

	boolean hasSsn(String ssn);

	ITax getTax();

	ISalary getSalary();

	void setTax(ITax buildTax);

	String getType();

	void setType(String type);

	void setCurrentBuilder(IEmployeeBuilder currentBuilder);

	IEmployeeBuilder getCurrentBuilder();

	void setSalary(ISalary salary);

}
