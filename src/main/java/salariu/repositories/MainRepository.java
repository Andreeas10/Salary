package salariu.repositories;

public class MainRepository implements IMainRepository {

	private IEmployeeRepository employeeRepository;
	private ITaxRepository taxRepository;

	public MainRepository(IEmployeeRepository employeeRepository, ITaxRepository taxRepository) {
		super();
		this.employeeRepository = employeeRepository;
		this.taxRepository = taxRepository;

	}

	@Override
	public IEmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	@Override
	public ITaxRepository getTaxRepository() {
		return taxRepository;
	}

	@Override
	public double getSalesPercentage() {
		// TODO Auto-generated method stub
		return 0.20;
	}

}
