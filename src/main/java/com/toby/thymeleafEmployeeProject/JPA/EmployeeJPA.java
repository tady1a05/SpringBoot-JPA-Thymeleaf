package com.toby.thymeleafEmployeeProject.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toby.thymeleafEmployeeProject.Entity.Employee;


public interface EmployeeJPA extends JpaRepository<Employee, Integer> {

}
