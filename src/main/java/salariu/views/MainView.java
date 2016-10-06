package salariu.views;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import salariu.controllers.IMainViewController;
import salariu.model.IEmployee;

public class MainView extends JFrame {

	private IMainViewController mainViewController;
	private JTextField ssnField;
	private JButton btnChangeTaxes;

	public void reset() {
		ssnField.setText("");
	}

	public MainView(IMainViewController mainViewController) {
		super("Salary");
		this.mainViewController = mainViewController;
		initialize();
	}

	private void initialize() {

		setBounds(100, 100, 546, 371);
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("appIcon.png")));

		JLabel lblNewLabel = new JLabel("SSN");
		lblNewLabel.setBounds(105, 35, 35, 46);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(lblNewLabel);

		ssnField = new JTextField();

		ssnField.setBounds(209, 43, 149, 31);
		ssnField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(ssnField);
		ssnField.setColumns(10);

		JButton addBtn = new JButton("Add");
		addBtn.setBounds(129, 191, 123, 23);
		addBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("addicon.png")));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainViewController.openAddViewController();
				reset();
			}
		});
		getContentPane().add(addBtn);

		JButton searchBtn = new JButton("Search\r\n");
		searchBtn.setBounds(61, 114, 123, 23);
		getContentPane().add(searchBtn);
		searchBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("searchIcon.png")));
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mainViewController.searchViewDetailsController(getEmployeeSsn());

			}
		});
		getContentPane().add(searchBtn);

		JButton showBtn = new JButton("Show Employee Tabel\r\n");
		showBtn.setBounds(194, 262, 179, 23);
		showBtn.setIcon(new ImageIcon(getClass().getClassLoader().getResource("showEmployeeTabelIcon.png")));
		showBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainViewController.showEmployeeTabel();

			}
		});
		getContentPane().add(showBtn);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(376, 114, 123, 23);
		getContentPane().add(btnDelete);
		btnDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("userDeleteIcon.png")));
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainViewController.removeEmployee(getEmployeeSsn());
				reset();

			}
		});

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(215, 114, 123, 23);
		getContentPane().add(btnUpdate);
		btnUpdate.setIcon(new ImageIcon(getClass().getClassLoader().getResource("editIcon.png")));
		
		btnChangeTaxes = new JButton("Change Taxes");
		btnChangeTaxes.setBounds(291, 191, 123, 23);
		getContentPane().add(btnChangeTaxes);
		btnChangeTaxes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainViewController.updateEmployee(getEmployeeSsn());
				reset();
				
			}
		});
		
		
		
		

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				mainViewController.serializedata();

			}
		});
	}

	public String getEmployeeSsn() {
		return ssnField.getText();
	}
}
