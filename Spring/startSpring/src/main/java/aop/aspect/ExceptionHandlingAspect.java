package aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandlingAspect {
    @Before("aop.aspect.MyPointcuts.allAddMethods()")
    public void beforeAddExceptionHandingAdvice()
    {
        System.out.println("beforeGetExceptionHandingAdvice: ловим/обрабатываем исключения при попытке получить книгу/журнал");
        System.out.println("------------------------------------");
    }
}
