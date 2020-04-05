package pckg;

import java.util.ArrayList;

public class Company {
	
	public String name;
	private int totalBalance;
	private ArrayList<Department> departments = new ArrayList();
	private Employee ceo;
//	Employee ceo = new Employee("Roope Ankka", "01.01.1857", "Rahasäiliö, Ankkalinna", "FI1234567890123456", 100000);
	
	public Company(String name, Employee ceo) {
		this.name = name;
		this.ceo = ceo;
		createHQ(ceo, "Ankkalinna");
	}
	
	
	private void createHQ(Employee ceo, String location){
		
		createDepartment(ceo, location);
	}
	
	private void createDepartment(Employee head, String location) {
		Department dep = new Department(head, location);
		addNewDepartment(dep);
	}
	
	private void addNewDepartment(Department department) {
		departments.add(department);
	}
	
	private void companyPayday() {
		for(Department dep: departments) {
			dep.departmentPayday();
		}
		this.setCompanyBalance();
	}
	
	private void setCompanyBalance() {
		this.totalBalance = 0;
		for(Department d : departments) {
			this.totalBalance += d.getBankBalance();
		}
	}
}
