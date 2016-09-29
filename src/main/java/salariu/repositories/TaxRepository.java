package salariu.repositories;

public class TaxRepository implements ITaxRepository {

	public TaxRepository() {

	}

	@Override
	public double getPercentOfCAS1() {
		// TODO Auto-generated method stub
		return 10.5;
	}

	@Override
	public double getPercentOfCAS2() {
		// TODO Auto-generated method stub
		return 15.8;
	}

	@Override
	public double getPercentOfCASS1() {
		// TODO Auto-generated method stub
		return 5.5;
	}

	@Override
	public double getPercentOfCASS2() {
		// TODO Auto-generated method stub
		return 5.2;
	}

	@Override
	public double getPercentOfCFS1() {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public double getPrecentOfCFS2() {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public double getPercentOfIV1() {
		// TODO Auto-generated method stub
		return 16.0;
	}

	@Override
	public double getPercentOfCCI2() {
		// TODO Auto-generated method stub
		return 0.85;
	}

	@Override
	public double getPercentOfFGPCS2() {
		// TODO Auto-generated method stub
		return 0.25;
	}

	@Override
	public double getPercentOfAMBP2() {
		// TODO Auto-generated method stub
		return 0.15;
	}

	@Override
	public double getTaxPercentForSample() {
		// TODO Auto-generated method stub
		return 0.7014;
	}

	@Override
	public double getTaxPercentForProgrammer() {
		// TODO Auto-generated method stub
		return 0.835;
	}

	@Override
	public double getTaxPercentForDisabled() {
		// TODO Auto-generated method stub
		return 0.89;
	}

}
