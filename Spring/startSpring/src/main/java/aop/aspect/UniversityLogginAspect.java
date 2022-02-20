package aop.aspect;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLogginAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLogginAdvice()
//    {
//        System.out.println("beforeGetStudentsLogginAdvice: логируем получение списка студентов перед методом getStudents");
//    }

//    @AfterReturning(pointcut = "execution(* getStudents())",  returning = "students")
//    public void afterReturningGetStudentsLogginAdvice(List<Student> students)
//    {
//        Student firstStudents = students.get(0);
//        String nameSurname = firstStudents.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudents.setNameSurname(nameSurname);
//        double avgGrade = firstStudents.getAvgGrade();
//        avgGrade = avgGrade+1;
//        firstStudents.setAvgGrade(avgGrade);
//
//        System.out.println("afterReturningGetStudentsLogginAdvice: логируем получение списка студентов после работы метода getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())"
//                    , throwing = "exception")
//    public void afterThrowingGetStudentsLogginAdvice(Throwable exception)
//    {
//        System.out.println("afterThrowingGetStudentsLogginAdvice: логируем выброс исключения " + exception);
//    }

        @After("execution(* getStudents())")
        public void afterGetStudentsLogginAdvice()
    {
        System.out.println("afterGetStudentsLogginAdvice: логируем нормальное окончание работы метода"
        + " или выброс исключения");
    }

}
