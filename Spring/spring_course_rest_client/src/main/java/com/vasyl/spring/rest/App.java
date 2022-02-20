package com.vasyl.spring.rest;

import com.vasyl.spring.rest.configuration.myConfig;
import com.vasyl.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(myConfig.class);

        Communication communication = context.getBean("communication", Communication.class);

//        List<Employee> allEmployees = communication.getAllEmployees();
//        System.out.println(allEmployees);

//        Employee empById = communication.getEmployee(1);
//        System.out.println(empById);
//
//        Employee emp = new Employee("Sveta1", "Sokolova1", "IT", 1200);
//        communication.saveEmployee(emp);

        communication.deleteEmployee(12);
    }
}

