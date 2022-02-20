package com.vasyl.spring.springboot.spring_course_springboot.service;


import com.vasyl.spring.springboot.spring_course_springboot.dao.EmployeeDAO;
import com.vasyl.spring.springboot.spring_course_springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployee();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    public Employee getEmployee(int id)
    {

        return employeeDAO.getEmployee(id);
    }

    @Transactional
    public void deleteEmployee(int id)
    {
        employeeDAO.deleteEmployee(id);
    }
}
