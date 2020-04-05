package pckg;

import java.util.ArrayList;

public class Department {
	private Employee head; //Head of the department
	private int bankBalance = 1000000;
	private String location;
	private ArrayList<Employee> employees = new ArrayList();
	
	public Department(Employee head, String location) {
		this.head = head;
		this.location = location;
	}
	
	//BANKBALANCE RELATED METHODS
	
	//You could just have setBalance(int balance), but I find this better.
	private void takeFromBalance(int amount) {
		bankBalance -=amount;
	}
	
	//You could just have setBalance(int balance), but I find this better.	
	private void addToBalance(int amount) {
		bankBalance +=amount;
	}
	
	public int getBankBalance() {
		return bankBalance;
	}
	
	//This should have some kind of sanitation
	public void departmentPayday() {
		for(Employee e : employees) {
			this.takeFromBalance(e.getSalary());
		}
	}
		
	//This should have some kind of sanitation
	public void customerIsBilled(int amount) {
		this.addToBalance(amount);
	}
	
	
	//EMPLOYEE RELATED METHODS
	
	private void hireEmployee(Employee employee) {
		employees.add(employee);
		employee.changeDepartment(this);
	}
	
	private void fireEmployee(Employee employee) {
		employees.remove(employee);
		employee.changeDepartment(null);
		
		//Makes the first in line (pun intended) the head of department.
		if(employee == head) {
			head = employees.get(0);
		}
	}
	
}
