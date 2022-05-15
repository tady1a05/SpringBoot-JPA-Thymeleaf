package com.toby.thymeleafEmployeeProject.Dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toby.thymeleafEmployeeProject.Entity.Employee;
import com.toby.thymeleafEmployeeProject.JPA.EmployeeJPA;

@Repository
public class EmployeeDao implements EmployeeDaoIntf{
	@Autowired
	public EmployeeJPA employeeJPA;
	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = (ArrayList<Employee>) employeeJPA.findAll();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = employeeJPA.getById(id);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee ret_employee = employeeJPA.save(employee);
		return  ret_employee;
	}


	@Override
	public String deleteEmployeeById(int id) {
		employeeJPA.deleteById(id);
		return "Success";
	}

}
