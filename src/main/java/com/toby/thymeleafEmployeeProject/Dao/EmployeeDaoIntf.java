package com.toby.thymeleafEmployeeProject.Dao;

import java.util.ArrayList;

import com.toby.thymeleafEmployeeProject.Entity.Employee;

public interface EmployeeDaoIntf {
	public ArrayList<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public Employee saveEmployee(Employee employee);
	public String deleteEmployeeById(int id);
}
