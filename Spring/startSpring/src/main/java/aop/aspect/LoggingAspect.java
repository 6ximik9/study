package aop.aspect;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
//
//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary()
//    {
//
//    }
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary()
//    {
//
//    }
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniLibrary()
//    {
//
//    }
//
//    @Before("allMethodsExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice()
//    {
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//    }
//
//

//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary()
//    {
//
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary()
//    {
//
//    }
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    public void allGetAndReturnMethodsFromUniLibrary()
//    {
//
//    }
//
//    @Before("allGetAndReturnMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLogginAdvice()
//    {
//        System.out.println("beforeGetLogginAdvice: write Log #3");
//    }
//
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLogginAdvice()
//    {
//        System.out.println("beforeGetLogginAdvice: write Log #2");
//    }
//
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLogginAdvice()
//    {
//        System.out.println("beforeGetLogginAdvice: write Log #1");
//    }




    @Before("aop.aspect.MyPointcuts.allAddMethods()")
    public void beforeAddBookAdvice(JoinPoint joinPoint)
    {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if(methodSignature.getName().equals("addBook"))
        {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj:arguments)
            {
                if(obj instanceof Book)
                {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: названяе - " +
                        myBook.getName() + ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String)
                {
                    System.out.println("Книгу добавляет " + obj);
                }
            }
        }
        System.out.println("------------------------------------");
        System.out.println("beforeGetBookAdvice: логирование попытки получить книгу/журнал");
        System.out.println("------------------------------------");
    }



}
