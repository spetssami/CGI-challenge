package pckg;

import java.util.ArrayList;

public class Company {
	
	public String name;
	private int totalBalance;
	private ArrayList<Department> departments = new ArrayList();
	private Employee ceo;
	
	public Company(String name, Employee ceo, String location) {
		this.name = name;
		this.ceo = ceo;
		createHQ(ceo, location);
	}
	
	
	private void createHQ(Employee ceo, String location){
		
		createDepartment("HQ", ceo, location);
	}
	
	public Department createDepartment(String name, Employee head, String location) {
		Department d = new Department(name, head, location, this);
		addNewDepartment(d);
		return d;
	}
	
	private void addNewDepartment(Department department) {
		departments.add(department);
	}
	
	public void companyPayday() {
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
	
	public int getCompanyBalance() {
		return this.totalBalance;
	}
	
	public void listDepartments() {
		for(Department i : departments) {
			System.out.println(i.getName());
		}
	}
}
