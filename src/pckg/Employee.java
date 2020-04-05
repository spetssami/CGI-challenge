package pckg;

public class Employee {
	
	private final String name;
	private double taxes; // Goverment's cut, between 0.00-1.00
	private double bankBalance = 1500; 
	private int salary;
	
	private Department department;
	
	public Employee(String name, int salary, double taxes) {
		this.name = name;
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
		double afterTaxes = Math.round((this.salary*taxes)*100)/100;
		this.bankBalance += afterTaxes;
	}
	
	public void employeePayday() {
		this.addToBankAccount();
	}
	
	public int getSalary() {
		return salary;
	}
	
	public double getBalance() {
		return bankBalance;
	}
	
	public String getName() {
		return this.name;
	}
	
}
