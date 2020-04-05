package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pckg.Company;
import pckg.Department;
import pckg.Employee;

class Tests {

	Employee employee = new Employee("John Doe", 3000, 0.33);
	Employee jane = new Employee("Jane Doe", 2800, 0.25);
	Employee moe = new Employee("Moe", 4500, 0.17);
	
	Company c = new Company("Bank", employee, "Finland");
	
	Department d = c.createDepartment("IT", employee, "Ankkalinna");
	Department d2 = c.createDepartment("Sales", jane, "Kouvola");
	
	
	@Test
	//Class Company
	//companyPayday() and setCompanyBalance()
	void companyBalance() {
		c.listDepartments();
		c.companyPayday();
		assertEquals(2991200, c.getCompanyBalance());
	}
	
	@Test
	//Class Department
	//hireEmployee() and fireEmployee()
	void hiringAndFiringMethods() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		list.add(moe);
		list.add(jane);
		
		ArrayList<Employee> list2 = new ArrayList<Employee>();
		list2.add(employee);
		list2.add(moe);
		
		d.hireEmployee(moe);
		d.hireEmployee(jane);
		
		assertEquals(list, d.listOfEmployees());
		assertNotEquals(list2, d.listOfEmployees());
		
		d.fireEmployee(jane);
		
		assertEquals(list2, d.listOfEmployees());
		assertNotEquals(list, d.listOfEmployees());
	}

	@Test
	//Class Department
	//getBankBalance()
	void departmentBalance() {
		c.companyPayday();
		assertEquals(997000, d.getBankBalance());
	}
	
	@Test
	//Class Employee
	//getBalance();
	void employeeBalance() {
		c.companyPayday();
		assertEquals(3480.0, employee.getBalance());
		assertNotEquals(1501, employee.getBalance());
	}

}
