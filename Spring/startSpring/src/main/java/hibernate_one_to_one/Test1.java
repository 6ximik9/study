package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//
//            Employee emp = new Employee("Aleksandr", "Ivanov", "IT", 600);
//
//            Detail detail = new Detail("Baku", "123456789", "23423423@gmail.com");
//
//            emp.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(emp);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//            Session session = factory.getCurrentSession();
//
//            Employee emp = new Employee("Oleg", "Smirnov", "Sales", 500);
//
//            Detail detail = new Detail("Ukraine", "987654321", "oleg@gmail.com");
//
//            emp.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(emp);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Employee emp = session.get(Employee.class, 2);
//
//            session.delete(emp);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
