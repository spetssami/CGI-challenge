package pckg;

import java.util.ArrayList;

public class Department {
	
	private String name;
	private Employee head; //Head of the department
	private int bankBalance = 1000000;
	private String location;
	private ArrayList<Employee> employees = new ArrayList();
	
	private final Company company;
	
	public Department(String name, Employee head, String location, Company company) {
		this.name = name;
		this.head = head;
		this.location = location;
		this.hireEmployee(head);
		this.company = company;
	}
	
	//BANKBALANCE RELATED METHODS
	
	//You could just have setBalance(int balance), but I find this better.
	private void takeFromBalance(int amount) {
		this.bankBalance -=amount;
	}
	
	//You could just have setBalance(int balance), but I find this better.	
	private void addToBalance(int amount) {
		this.bankBalance +=amount;
	}
	
	public int getBankBalance() {
		return this.bankBalance;
	}
	
	//This should have some kind of sanitation
	public void departmentPayday() {
		for(Employee e : employees) {
			this.takeFromBalance(e.getSalary());
			e.employeePayday();
		}
	}
		
	//This should have some kind of sanitation
	public void customerIsBilled(int amount) {
		this.addToBalance(amount);
	}
	
	
	//EMPLOYEE RELATED METHODS
	
	public void hireEmployee(Employee employee) {
		employees.add(employee);
		employee.changeDepartment(this);
	}
	
	public void fireEmployee(Employee employee) {
		employees.remove(employee);
		employee.changeDepartment(null);
		
		//Makes the first in line (pun intended) the head of department.
		if(employee == head) {
			head = employees.get(0);
		}
	}
	
	public ArrayList<Employee> listOfEmployees() {
		return employees;
	}
	
	public String getName() {
		return this.name;
	}
}
