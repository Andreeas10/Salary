package salariu.model;

public class TaxSeller implements ITax{
	
	private ITax tax;

	public double getTotalTaxWithoutIV1() {
		return tax.getTotalTaxWithoutIV1();
	}

	public double getTotalTax1() {
		return tax.getTotalTax1();
	}

	public double getTotalTax2() {
		return tax.getTotalTax2();
	}

	public TaxSeller(ITax tax) {
		super();
		this.tax = tax;
	}

	public double getCAS1() {
		return tax.getCAS1();
	}

	public double getCAS2() {
		return tax.getCAS2();
	}

	public double getCASS1() {
		return tax.getCASS1();
	}

	public double getCASS2() {
		return tax.getCASS2();
	}

	public double getCFS1() {
		return tax.getCFS1();
	}

	public double getCFS2() {
		return tax.getCFS2();
	}

	public double getIV1() {
		return tax.getIV1();
	}

	public double getCCI2() {
		return tax.getCCI2();
	}

	public double getFGPCS2() {
		return tax.getFGPCS2();
	}

	public double getAMBP2() {
		return tax.getAMBP2();
	}

}
