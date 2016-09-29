package salariu.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import salariu.controllers.IUpdateViewController;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;

public class UpdateView extends JFrame {

	private IUpdateViewController updateViewController;

	private JTextField salaryField;
	private JLabel nameLbl;
	private JLabel lblSalary;
	private JButton btnSave;
	private JTextField nameField;

	private ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnNetSalary;
	private JRadioButton rdbtnGrossSalary;

	public UpdateView(IUpdateViewController updateViewController) {
		// TODO Auto-generated constructor stub
		this.updateViewController = updateViewController;
		initialize();
	}

	public void initialize() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("editIcon.png")));
		getContentPane().setLayout(null);
		setBounds(100, 100, 546, 371);

		nameLbl = new JLabel(" Employee");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLbl.setBounds(97, 33, 128, 31);
		getContentPane().add(nameLbl);

		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalary.setBounds(107, 111, 163, 31);
		getContentPane().add(lblSalary);

		btnSave = new JButton("Save\r\n");
		btnSave.setBounds(207, 277, 89, 23);
		getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateViewController.save(Double.parseDouble(salaryField.getText()));
				UpdateView.this.dispose();

			}
		});

		salaryField = new JTextField();
		salaryField.setColumns(10);
		salaryField.setBounds(321, 120, 86, 20);
		getContentPane().add(salaryField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(321, 42, 86, 20);
		nameField.setEditable(false);
		getContentPane().add(nameField);

		rdbtnNetSalary = new JRadioButton("Net Salary");
		buttonGroup_1.add(rdbtnNetSalary);
		rdbtnNetSalary.setSelected(true);
		rdbtnNetSalary.setBounds(310, 172, 198, 23);
		getContentPane().add(rdbtnNetSalary);
		rdbtnNetSalary.setEnabled(true);
		rdbtnNetSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateViewController.changeToNetSalaryBuilder();
			}
		});

		rdbtnGrossSalary = new JRadioButton("Gross Salary\r\n");
		buttonGroup_1.add(rdbtnGrossSalary);
		rdbtnGrossSalary.setBounds(310, 209, 198, 23);
		getContentPane().add(rdbtnGrossSalary);
		rdbtnGrossSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateViewController.changeToGrossSalaryBuilder();

			}

		});

	}

	public void setNameField(String name) {
		// TODO Auto-generated method stub

		nameField.setText(name);
	}

	public double getSalary() {
		// TODO Auto-generated method stub

		return Double.parseDouble(salaryField.getText());

	}
}
