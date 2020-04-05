package pckg;

public class Employee {
	
	private final String name;
	private final String ssn; //social security number, not used
	private String address; //not used
	private double taxes; // Goverment's cut, between 0.00-1.00
	private double bankAccount = 1500; 
	private int salary;
	
	private Department department;
	
	public Employee(String name, String ssn, String address, int salary, double taxes) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.salary = salary;
		this.taxes = taxes;
	}
	
	//DEPARTMENT RELATED METHODS
	
	public Department getDepartment() {
		return department;
	}
	
	private void setDepartment(Department department) {
		this.department = department;
	}
	
	public void changeDepartment(Department department) {
		setDepartment(department);
	}
	
	//BANK ACCOUNT RELATED METHODS
	
	private void addToBankAccount() {
		this.bankAccount += this.salary*taxes;
	}
	
	public void employeePayday() {
		this.addToBankAccount();
	}
	
	public int getSalary() {
		return salary;
	}
	
	
}
