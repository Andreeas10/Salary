package salariu.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import salariu.controllers.IViewDetailsController;
import salariu.model.IEmployee;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

public class ViewDetails extends JFrame {

	private IViewDetailsController viewDetailsController;
	private JTextField textField;
	private JLabel lblGrossSalary;
	private JLabel lblAsigurariSocialeDe;
	private JLabel lblFondulDeSomaj;
	private JLabel lblImpozitPeVenit;
	private JLabel lblImpozitpeVenit;
	private JLabel lblContributiiAngajator;
	private JLabel lblAsigurariSocialecas;
	private JLabel lblAsigurariSocialeDe_1;
	private JLabel lblFondulDeSomaj_2;
	private JLabel lblConcediiSiIndemnizatii;
	private JLabel lblCreanteSalarialefgpcs;
	private JLabel lblFondulDeRisc;
	private JLabel labelTotalTaxes;
	private JLabel lblNetSalary;
	private JLabel lblContributiiAngajat;
	private JTextField fieldCAS1;
	private JTextField fieldCASS1;
	private JTextField fieldCFS1;
	private JTextField fieldIV1;
	private JTextField fieldCAS2;
	private JTextField fieldCASS2;
	private JTextField fieldCFS2;
	private JTextField fieldCCI2;
	private JTextField fieldFGPCS2;
	private JTextField fieldAMBP2;
	private JTextField fieldTotalTaxes;
	private JTextField fieldGrossSalary;
	private JTextField fieldEmployerContributions;
	private JTextField fieldNetSalary;
	private JTextField fieldEmployeeContributions;
	private JLabel lblEmployee;
	private JLabel lblTax;
	private JLabel lblToPayA;
	private DecimalFormat df = new DecimalFormat("#.##");
	private JProgressBar progressBar;

	public ViewDetails(IViewDetailsController viewDetailsController) {
		super("ViewDetails");
		getContentPane().setForeground(Color.GREEN);
		this.viewDetailsController = viewDetailsController;
		initialize();

	}

	private void initialize() {

		
		setBounds(100, 100, 853, 797);
		getContentPane().setLayout(null);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("viewDetailsIcon.png")));

		lblGrossSalary = new JLabel("Gross Salary\r\n");
		lblGrossSalary.setBounds(21, 631, 170, 29);
		lblGrossSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblGrossSalary);

		lblAsigurariSocialeDe = new JLabel("Social Insurance (CAS)\t 10.5%");
		lblAsigurariSocialeDe.setBounds(21, 80, 225, 29);
		getContentPane().add(lblAsigurariSocialeDe);

		lblFondulDeSomaj = new JLabel("Health Insurance (CASS) \t 5.5%");
		lblFondulDeSomaj.setBounds(21, 125, 258, 29);
		getContentPane().add(lblFondulDeSomaj);

		lblImpozitPeVenit = new JLabel("Unemployment Benefit (CFS)\t 0.5%");
		lblImpozitPeVenit.setBounds(21, 165, 170, 29);
		getContentPane().add(lblImpozitPeVenit);

		lblImpozitpeVenit = new JLabel("Income Tax (IV) 16%");
		lblImpozitpeVenit.setBounds(21, 205, 170, 29);
		getContentPane().add(lblImpozitpeVenit);

		lblContributiiAngajator = new JLabel("Employer Contributions ");
		lblContributiiAngajator.setBounds(21, 257, 170, 29);
		lblContributiiAngajator.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblContributiiAngajator);

		lblAsigurariSocialecas = new JLabel("Social Insurance (CAS)\t 15.8%");
		lblAsigurariSocialecas.setBounds(21, 311, 170, 29);
		getContentPane().add(lblAsigurariSocialecas);

		lblAsigurariSocialeDe_1 = new JLabel("Health Insurance (CASS)  \t5.2%");
		lblAsigurariSocialeDe_1.setBounds(21, 351, 258, 29);
		getContentPane().add(lblAsigurariSocialeDe_1);

		lblFondulDeSomaj_2 = new JLabel("Unemployment Benefit (CFS)  \t0.5%");
		lblFondulDeSomaj_2.setBounds(21, 391, 225, 29);
		getContentPane().add(lblFondulDeSomaj_2);

		lblConcediiSiIndemnizatii = new JLabel("Leaves and Indemnities (CCI)\t  0.85%");
		lblConcediiSiIndemnizatii.setBounds(21, 431, 207, 29);
		getContentPane().add(lblConcediiSiIndemnizatii);

		lblCreanteSalarialefgpcs = new JLabel("Wage Caims (FGPCS)  \t  0.25%");
		lblCreanteSalarialefgpcs.setBounds(21, 471, 225, 29);
		getContentPane().add(lblCreanteSalarialefgpcs);

		lblFondulDeRisc = new JLabel("Risk Fund and Compensation (AMBP)\t 0.15%");
		lblFondulDeRisc.setBounds(21, 511, 258, 29);
		getContentPane().add(lblFondulDeRisc);

		fieldCAS1 = new JTextField();
		fieldCAS1.setEditable(false);
		fieldCAS1.setBounds(533, 84, 86, 20);
		fieldCAS1.setColumns(10);
		getContentPane().add(fieldCAS1);

		fieldCASS1 = new JTextField();
		fieldCASS1.setBounds(533, 129, 86, 20);
		fieldCASS1.setEditable(false);
		fieldCASS1.setColumns(10);
		getContentPane().add(fieldCASS1);

		fieldCFS1 = new JTextField();
		fieldCFS1.setBounds(533, 169, 86, 20);
		fieldCFS1.setEditable(false);
		fieldCFS1.setColumns(10);
		getContentPane().add(fieldCFS1);

		fieldIV1 = new JTextField();
		fieldIV1.setBounds(533, 209, 86, 20);
		fieldIV1.setEditable(false);
		fieldIV1.setColumns(10);
		getContentPane().add(fieldIV1);
		// mare atentie la IV

		fieldCAS2 = new JTextField();
		fieldCAS2.setBounds(533, 311, 86, 20);
		fieldCAS2.setEditable(false);
		fieldCAS2.setColumns(10);
		getContentPane().add(fieldCAS2);

		fieldCASS2 = new JTextField();
		fieldCASS2.setBounds(533, 351, 86, 20);
		fieldCASS2.setEditable(false);
		fieldCASS2.setColumns(10);
		getContentPane().add(fieldCASS2);

		fieldCFS2 = new JTextField();
		fieldCFS2.setBounds(533, 391, 86, 20);
		fieldCFS2.setEditable(false);
		fieldCFS2.setColumns(10);
		getContentPane().add(fieldCFS2);

		fieldCCI2 = new JTextField();
		fieldCCI2.setBounds(533, 431, 86, 20);
		fieldCCI2.setEditable(false);
		fieldCCI2.setColumns(10);
		getContentPane().add(fieldCCI2);

		fieldFGPCS2 = new JTextField();
		fieldFGPCS2.setBounds(533, 471, 86, 20);
		fieldFGPCS2.setEditable(false);
		fieldFGPCS2.setColumns(10);
		getContentPane().add(fieldFGPCS2);

		fieldAMBP2 = new JTextField();
		fieldAMBP2.setBounds(533, 511, 86, 20);
		fieldAMBP2.setEditable(false);
		fieldAMBP2.setColumns(10);
		getContentPane().add(fieldAMBP2);

		labelTotalTaxes = new JLabel("Total Taxes\r\n");
		labelTotalTaxes.setBounds(21, 551, 170, 29);
		labelTotalTaxes.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(labelTotalTaxes);

		fieldTotalTaxes = new JTextField();
		fieldTotalTaxes.setBounds(533, 557, 86, 20);
		fieldTotalTaxes.setEditable(false);
		fieldTotalTaxes.setColumns(10);
		getContentPane().add(fieldTotalTaxes);

		fieldGrossSalary = new JTextField();
		fieldGrossSalary.setBounds(533, 637, 86, 20);
		fieldGrossSalary.setEditable(false);
		fieldGrossSalary.setColumns(10);
		getContentPane().add(fieldGrossSalary);

		fieldEmployerContributions = new JTextField();
		fieldEmployerContributions.setBounds(533, 263, 86, 20);
		fieldEmployerContributions.setEditable(false);
		fieldEmployerContributions.setColumns(10);
		getContentPane().add(fieldEmployerContributions);

		lblNetSalary = new JLabel("Net Salary\r\n");
		lblNetSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNetSalary.setBounds(21, 591, 170, 29);
		getContentPane().add(lblNetSalary);

		lblContributiiAngajat = new JLabel("Employee Contributions");
		lblContributiiAngajat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContributiiAngajat.setBounds(21, 25, 170, 29);
		getContentPane().add(lblContributiiAngajat);

		fieldNetSalary = new JTextField();
		fieldNetSalary.setEditable(false);
		fieldNetSalary.setColumns(10);
		fieldNetSalary.setBounds(533, 597, 86, 20);
		getContentPane().add(fieldNetSalary);

		fieldEmployeeContributions = new JTextField();
		fieldEmployeeContributions.setEditable(false);
		fieldEmployeeContributions.setColumns(10);
		fieldEmployeeContributions.setBounds(533, 34, 86, 20);
		getContentPane().add(fieldEmployeeContributions);

		lblEmployee = new JLabel("Taxes " + String.valueOf(100 - viewDetailsController.getProgressBarValue()) + "%");
		lblEmployee.setBounds(518, 721, 86, 14);
		getContentPane().add(lblEmployee);

		lblTax = new JLabel("Employee " + String.valueOf(viewDetailsController.getProgressBarValue()) + "%");
		lblTax.setBounds(195, 721, 97, 14);
		getContentPane().add(lblTax);

		progressBar = new JProgressBar();

		progressBar.setToolTipText("This is a ProgressBar");

		progressBar.setBounds(80, 708, 575, 39);
		getContentPane().add(progressBar);
		progressBar.setValue(viewDetailsController.getProgressBarValue());

		lblToPayA = new JLabel(
				"To pay a net salary of " + String.valueOf(df.format(viewDetailsController.getNetSalary()))
						+" lei"+ " employer spends " + String.valueOf(df.format(viewDetailsController.getTotal()))+" lei");
		lblToPayA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblToPayA.setBounds(181, 671, 575, 29);
		getContentPane().add(lblToPayA);

	}

	public void setCAS1(double value) {

		fieldCAS1.setText(df.format(value));

	}

	public void setCAS2(double value) {

		fieldCAS2.setText(df.format(value));

	}

	public void setCASS1(double value) {

		fieldCASS1.setText(df.format(value));
	}

	public void setCASS2(double value) {

		fieldCASS2.setText(df.format(value));
	}

	public void setCFS1(double value) {

		fieldCFS1.setText(df.format(value));
	}

	public void setCFS2(double value) {

		fieldCFS2.setText(df.format(value));
	}

	public void setIV1(double value) {

		fieldIV1.setText(df.format(value));
	}

	public void setCCI2(double value) {

		fieldCCI2.setText(df.format(value));
	}

	public void setFGPCS2(double value) {

		fieldFGPCS2.setText(df.format(value));
	}

	public void setAMBP2(double value) {

		fieldAMBP2.setText(df.format(value));
	}

	public void setTotalTax1(double value) {

		fieldEmployeeContributions.setText(df.format(value));

	}

	public void setTotalTax2(double value) {

		fieldEmployerContributions.setText(df.format(value));
	}

	public void setNetSalary(double value) {

		fieldNetSalary.setText(df.format(value));

	}

	public void setGrossSalary(double value) {

		fieldGrossSalary.setText(df.format(value));

	}

	public void setTotalFees(double value) {

		fieldTotalTaxes.setText(df.format(value));

	}
}
