package com.vasyl.spring.springboot.spring_course_springboot.dao;


import com.vasyl.spring.springboot.spring_course_springboot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployee() {
//
//        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("FROM Employee"
//                        , Employee.class)
//                .getResultList();
        Query query = entityManager.createQuery("FROM Employee");

        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

       Employee emp =  entityManager.merge(employee);
       employee.setId(emp.getId());
    }

    @Override
    public Employee getEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        Employee employee = entityManager.find(Employee.class, id);
        return  employee;
    }

    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
//
//        query.setParameter("employeeId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }


}
