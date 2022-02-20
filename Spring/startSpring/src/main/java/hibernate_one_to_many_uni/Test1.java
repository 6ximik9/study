package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Department dep  = session.get(Department.class,7);
//
//            System.out.println("sdsd " + dep);
//            System.out.println("sdsd " + dep.getEmps());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

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

            session = factory.getCurrentSession();

            session.beginTransaction();

            Department dep = session.get(Department.class,8);

            session.delete(dep);

            session.getTransaction().commit();
            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            Department dep = new Department("HR", 500, 1500);
//
//            Employee emp = new Employee("Oleg", "Ivanov", 800);
//
//            Employee emp2 = new Employee("Andrey", "Sidorova", 1000);
//
//            dep.addEmployeeDepartment(emp);
//            dep.addEmployeeDepartment(emp2);
//
//            session.beginTransaction();
//
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
