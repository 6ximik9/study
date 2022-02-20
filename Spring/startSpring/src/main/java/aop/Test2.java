package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> student = university.getStudents();
            System.out.println(student);
        }
        catch (Exception e)
        {
            System.out.println("Было поймано исключение " + e);
        }


        context.close();

    }
}
