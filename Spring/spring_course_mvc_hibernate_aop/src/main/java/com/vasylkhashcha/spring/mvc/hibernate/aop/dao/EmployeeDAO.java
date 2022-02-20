package com.vasylkhashcha.spring.mvc.hibernate.aop.dao;

import com.vasylkhashcha.spring.mvc.hibernate.aop.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
