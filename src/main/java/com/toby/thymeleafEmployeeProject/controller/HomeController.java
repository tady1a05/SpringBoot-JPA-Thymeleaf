package com.toby.thymeleafEmployeeProject.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toby.thymeleafEmployeeProject.Dao.EmployeeDaoIntf;
import com.toby.thymeleafEmployeeProject.Entity.Employee;

@Controller
public class HomeController {
	@Autowired
	public EmployeeDaoIntf employeeIntf;
	@RequestMapping("employee/list")
	public String listAllEmployee(Model model) {
		ArrayList<Employee> employees = employeeIntf.getAllEmployees();
		model.addAttribute("employees", employees);
		return "employee/AllEmployee";
	}
	
	@RequestMapping("employee/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/EmployeeForm";
	}
	
	@RequestMapping("employee/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeIntf.saveEmployee(employee);
		return "redirect:/employee/list";
	}
	
	@RequestMapping("employee/showFormForUpdate")
	public String showFormForAdd(@RequestParam("employeeId") String employeeId,Model model) {
		Employee employee = employeeIntf.getEmployeeById(Integer.parseInt(employeeId));
		model.addAttribute("employee", employee);
		return "employee/EmployeeForm";
	}
	
	@RequestMapping("employee/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId") String employeeId) {
		employeeIntf.deleteEmployeeById(Integer.parseInt(employeeId));
		return "redirect:/employee/list";
	}
}
