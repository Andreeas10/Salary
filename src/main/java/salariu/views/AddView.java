package salariu.views;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import salariu.controllers.IAddViewController;
import salariu.model.DoubleJTextField;
import salariu.model.ISalary;
import salariu.model.Salary;
import salariu.repositories.IEmployeeRepository;

import javax.swing.JPanel;

public class AddView extends JFrame {

	private IAddViewController addViewController;

	private JTextField nameField;
	private JTextField salaryField;
	private JTextField ssnField;
	private JCheckBox chckbxProgrammer;
	private JCheckBox chckbxDisabledPerson;
	private JCheckBox chckbxSellerEmployee;
	private JRadioButton rdbtnNetSalary;
	private JRadioButton rdbtnGrossSalary;
	private JTextField salesField;
	private JButton btnSave;
	private JCheckBox chckbxSample;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JPanel panel;

	public AddView(IAddViewController addViewController) {
		super("AddEmployee");
		this.addViewController = addViewController;
		initialize();
	}

	public void reset() {
		nameField.setText("");
		salaryField.setText("");
		ssnField.setText("");
		buttonGroup.clearSelection();
		buttonGroup_1.clearSelection();
	}

	private void initialize() {

		setBounds(100, 100, 741, 685);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("addUserIcon.png")));

		JLabel lblName = new JLabel("Name\r\n");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(27, 73, 122, 21);
		getContentPane().add(lblName);

		nameField = new JTextField();
		nameField.setBounds(369, 73, 198, 28);
		getContentPane().add(nameField);
		nameField.setColumns(10);

		JLabel lblSsn = new JLabel("Ssn");
		lblSsn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSsn.setBounds(27, 130, 122, 21);
		getContentPane().add(lblSsn);

		ssnField = new JTextField();
		ssnField.setColumns(10);
		ssnField.setBounds(369, 130, 198, 28);
		getContentPane().add(ssnField);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSalary.setBounds(27, 192, 122, 21);
		getContentPane().add(lblSalary);

		salaryField = new JTextField();
		salaryField.setColumns(10);
		salaryField.setBounds(369, 196, 198, 28);
		getContentPane().add(salaryField);

		rdbtnNetSalary = new JRadioButton("Net Salary");
		buttonGroup_1.add(rdbtnNetSalary);
		rdbtnNetSalary.setSelected(true);
		rdbtnNetSalary.setBounds(369, 244, 198, 23);
		getContentPane().add(rdbtnNetSalary);
		rdbtnNetSalary.setEnabled(true);
		rdbtnNetSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addViewController.changeToNetSalaryBuilder();
			}
		});

		rdbtnGrossSalary = new JRadioButton("Gross Salary\r\n");
		buttonGroup_1.add(rdbtnGrossSalary);
		rdbtnGrossSalary.setBounds(369, 286, 198, 23);
		getContentPane().add(rdbtnGrossSalary);
		rdbtnGrossSalary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addViewController.changeToGrossSalaryBuilder();

			}

		});

		JLabel lblType = new JLabel("Employee type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblType.setBounds(27, 313, 157, 49);
		getContentPane().add(lblType);

		chckbxProgrammer = new JCheckBox("Programmer\r\n");
		buttonGroup.add(chckbxProgrammer);
		chckbxProgrammer.setBounds(369, 377, 186, 23);
		getContentPane().add(chckbxProgrammer);
		chckbxProgrammer.setToolTipText("Programator cu IV=0");

		chckbxProgrammer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addViewController.changeToProgrammerEmployeeBuilder();
				panel.setVisible(false);

			}
		});

		JCheckBox chckbxDisabledPerson = new JCheckBox("Disabled Person\r\n\r\n");
		buttonGroup.add(chckbxDisabledPerson);
		chckbxDisabledPerson.setBounds(369, 415, 186, 23);
		getContentPane().add(chckbxDisabledPerson);
		chckbxDisabledPerson.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addViewController.changeToDisabledEmployeeBuilder();
				panel.setVisible(false);

			}

		});

		panel = new JPanel();
		panel.setBounds(27, 497, 688, 104);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		JLabel lblSales = new JLabel("Sales");
		lblSales.setBounds(0, 27, 55, 25);
		lblSales.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblSales);

		salesField = new DoubleJTextField();
		salesField.setColumns(10);
		salesField.setBounds(350, 29, 198, 28);
		panel.add(salesField);
		salesField.setText("0");
		salesField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				changeToSellerBuilder();
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				changeToSellerBuilder();
			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				changeToSellerBuilder();
			}

			private void changeToSellerBuilder() {
				if (salesMoneyIsNotNull()) {
					addViewController.changeToSellerEmployeeBuilder();
				}
			}
		});

		chckbxSellerEmployee = new JCheckBox("Employee paid according to sales");
		buttonGroup.add(chckbxSellerEmployee);
		chckbxSellerEmployee.setBounds(369, 456, 295, 23);
		getContentPane().add(chckbxSellerEmployee);
		chckbxSellerEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				panel.setVisible(!panel.isVisible());
				addViewController.changeToSellerEmployeeBuilder();

			}

		});

		btnSave = new JButton("Save");
		btnSave.setBounds(283, 612, 122, 23);

		getContentPane().add(btnSave);

		chckbxSample = new JCheckBox("Sample\r\n");
		chckbxSample.setSelected(true);
		buttonGroup.add(chckbxSample);
		chckbxSample.setBounds(369, 339, 186, 23);
		getContentPane().add(chckbxSample);

		chckbxSample.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addViewController.changeToSampleEmployeeBuilder();
				panel.setVisible(false);

			}
		});

		btnSave.setIcon(new ImageIcon(getClass().getClassLoader().getResource("saveIcon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addViewController.addEmployee();
				AddView.this.dispose();

				reset();

			}

		});
	}

	protected boolean salesMoneyIsNotNull() {
		return !salesField.getText().equals(null) && salesField.getText().length() != 0;
	}

	public String getEmployeeSsn() {

		return ssnField.getText();
	}

	public String getEmployeeName() {
		return nameField.getText();
	}

	public double getSalary() {
		return Double.parseDouble(salaryField.getText());
	}

	public double getSales() {
		return Double.parseDouble(salesField.getText());
	}
}
