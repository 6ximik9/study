package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLOutput;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

            System.out.println("Get department");
            Department dep = session.get(Department.class,9);

            System.out.println("Show department ");
            System.out.println(dep);

            System.out.println("Show employees of the department");
            System.out.println(dep.getEmps());

            System.out.println("Подгрузим наших работников");
            dep.getEmps().get(0);

            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(dep.getEmps());
            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class,1);
//
//            System.out.println("sdsd " + emp);
//            System.out.println("sdsd " + emp.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class,6);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            Department dep = new Department("Sales", 800, 1500);
//
//            Employee emp = new Employee("Vasyl", "Khashcha", 800);
//
//            Employee emp2 = new Employee("Elena", "Sidorova", 1000);
//
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            dep.addEmployeeDepartment(emp);
//            dep.addEmployeeDepartment(emp2);
//            dep.addEmployeeDepartment(emp3);
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
