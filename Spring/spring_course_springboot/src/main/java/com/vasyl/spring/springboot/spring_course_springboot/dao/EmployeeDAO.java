package com.vasyl.spring.springboot.spring_course_springboot.dao;

import com.vasyl.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
