package salariu.app;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import salariu.controllers.IMainViewController;
import salariu.controllers.MainViewController;
import salariu.repositories.EmployeeRepository;
import salariu.repositories.IEmployeeRepository;
import salariu.repositories.IMainRepository;
import salariu.repositories.ITaxRepository;
import salariu.repositories.MainRepository;
import salariu.repositories.RepositorySerializator;
import salariu.repositories.TaxRepository;
import salariu.views.MainView;

public class App extends JFrame {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				IEmployeeRepository employeeRepository = new EmployeeRepository();
				ITaxRepository taxRepository = new TaxRepository();
				IMainRepository mainRepository = new MainRepository(employeeRepository, taxRepository);
				
				RepositorySerializator repositorySerializator = new RepositorySerializator();
				try {
					mainRepository = repositorySerializator.deserialize();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				IMainViewController mainViewController = new MainViewController(mainRepository,repositorySerializator);
				MainView mainView = new MainView(mainViewController);
				mainView.setVisible(true);

			}
		});
	}
}