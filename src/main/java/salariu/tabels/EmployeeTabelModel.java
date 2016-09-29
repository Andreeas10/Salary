package salariu.tabels;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import salariu.model.IEmployee;
import salariu.model.Salary;

public class EmployeeTabelModel extends AbstractTableModel {

	private String[] columns = { "Name", "Ssn", "Net Salary", "Gross Salary", "Type" };

	private List<IEmployee> employees = new ArrayList<>();

	/*
	 * public EmployeeTabelModel() { super(); employees.add(firstEmployee);
	 * fireTableDataChanged();
	 * 
	 * }
	 */

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return employees.get(rowIndex).getName();
		case 1:
			return employees.get(rowIndex).getSsn();
		case 2:
			DecimalFormat df = new DecimalFormat("#.##");
			return (df.format(employees.get(rowIndex).getSalary().getNetSalary()));

		case 3:
			DecimalFormat df1 = new DecimalFormat("#.##");
			return (df1.format(employees.get(rowIndex).getSalary().getGrossSalary()));
		case 4:
			return employees.get(rowIndex).getType();
		}

		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			employees.get(rowIndex).setName(aValue.toString());
			break;
		case 1:
			employees.get(rowIndex).setSsn(aValue.toString());
			break;
		case 2:
			employees.get(rowIndex).getSalary().setNetSalary(Double.parseDouble(aValue.toString()));

			break;
		case 3:
			employees.get(rowIndex).getSalary().setGrossSalary(Double.parseDouble(aValue.toString()));

			break;
		case 4:
			employees.get(rowIndex).setType(aValue.toString());
			break;
		}

	}

	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	public void setEmployees(List<IEmployee> employees) {
		this.employees = employees;
		fireTableDataChanged();
	}

	public void clearEmployees() {
		employees = new ArrayList<>();
		fireTableDataChanged();
	}

	public IEmployee getEmployeeAtRow(int row) {
		return employees.get(row);
	}

	public void update() {
		fireTableDataChanged();
	}

}