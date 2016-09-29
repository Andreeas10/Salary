package salariu.tabels;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import salariu.controllers.IViewDetailsController;
import salariu.controllers.ViewDetailsController;
import salariu.model.IEmployee;
import salariu.repositories.IEmployeeRepository;
import salariu.repositories.IMainRepository;
import salariu.views.ViewDetails;

public class DisplayTabel extends JFrame {

	private List<IEmployee> listEmployee;
	private JTable table;
	private EmployeeTabelModel model;

	public DisplayTabel(IMainRepository repository) {

		setTitle("Employee tabel");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("tableIcon.png")));
		table = new JTable();
		model = new EmployeeTabelModel();
		model.setEmployees(repository.getEmployeeRepository().getEmployeeList());
		JScrollPane scrollPane = new JScrollPane(table);
		table.setModel(model);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					IViewDetailsController viewDetailsController = new ViewDetailsController(repository,
							getSelectedEmplyee());
					ViewDetails viewDetails = new ViewDetails(viewDetailsController);
					viewDetailsController.setViewDetails(viewDetails);
					viewDetailsController.populateFieldsViewDetails();
					viewDetails.setVisible(true);
				}
			}
		});

		pack();

	}

	public IEmployee getSelectedEmplyee() {
		return model.getEmployeeAtRow(table.getSelectedRow());
	}

	public void updateModel() {
		// TODO Auto-generated method stub
		model.update();

	}

}
