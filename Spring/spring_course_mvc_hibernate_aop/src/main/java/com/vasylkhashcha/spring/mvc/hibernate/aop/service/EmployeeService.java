package com.vasylkhashcha.spring.mvc.hibernate.aop.service;

import com.vasylkhashcha.spring.mvc.hibernate.aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
