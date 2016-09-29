package salariu.model;

import salariu.repositories.ITaxRepository;

public class Tax implements ITax {

	private double grossSalary;
	private ITaxRepository taxRepository;

	public Tax(double grossSalary, ITaxRepository taxRepository) {
		super();
		this.grossSalary = grossSalary;
		this.taxRepository = taxRepository;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public double getCAS1() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCAS1(), grossSalary);
	}

	@Override
	public double getCAS2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCAS2(), grossSalary);
	}

	@Override
	public double getCASS1() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCASS1(), grossSalary);
	}

	@Override
	public double getCASS2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCASS2(), grossSalary);
	}

	@Override
	public double getCFS1() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCFS1(), grossSalary);
	}

	@Override
	public double getCFS2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPrecentOfCFS2(), grossSalary);
	}

	@Override
	public double getIV1() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfIV1(), grossSalary - getTotalTaxWithoutIV1());
	}

	@Override
	public double getCCI2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfCCI2(), grossSalary);
	}

	@Override
	public double getFGPCS2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfFGPCS2(), grossSalary);
	}

	@Override
	public double getAMBP2() {
		// TODO Auto-generated method stub
		return calculatePercentFromValue(taxRepository.getPercentOfAMBP2(), grossSalary);
	}

	public double calculatePercentFromValue(double percent, double value) {

		return (percent / 100 * value);

	}

	@Override
	public double getTotalTax2() {
		// TODO Auto-generated method stub
		return getCAS2() + getCASS2() + getCFS2() + getCCI2() + getFGPCS2() + getAMBP2();
	}

	@Override
	public double getTotalTaxWithoutIV1() {
		// TODO Auto-generated method stub
		return getCAS1() + getCASS1() + getCFS1();
	}

	@Override
	public double getTotalTax1() {
		// TODO Auto-generated method stub
		return getCAS1() + getCASS1() + getCFS1() + getIV1();
	}

}
