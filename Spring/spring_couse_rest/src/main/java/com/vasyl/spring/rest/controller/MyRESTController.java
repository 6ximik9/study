package com.vasyl.spring.rest.controller;


import com.vasyl.spring.rest.entity.Employee;
import com.vasyl.spring.rest.exception_handing.NoSuchEmployeeException;
import com.vasyl.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees()
    {
        List<Employee> allEmployees = employeeService.getAllEmployee();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.getEmployee(id);

        if(employee==null)
        {
            throw new NoSuchEmployeeException("There is no employee with ID = "+ id + " int DataBase");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee emp)
    {

        employeeService.saveEmployee(emp);

        return emp;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee emp)
    {

        employeeService.saveEmployee(emp);

        return emp;
    }

    @DeleteMapping("employee")
    public String deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null)
        {
            throw new NoSuchEmployeeException("There is no employee with ID = "+ id + " in Database");
        }

        employeeService.deleteEmployee(id);

        return "Employee with ID = " + id + "was deleted";
    }
}
