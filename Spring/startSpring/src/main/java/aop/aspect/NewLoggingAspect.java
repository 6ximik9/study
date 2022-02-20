package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотку пытаются вернуть  книгу");
        Object targetMethodResult = null;
        try{
            targetMethodResult =  proceedingJoinPoint.proceed();
        }
        catch (Exception ex)
        {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + ex);
           throw ex;
        }


        System.out.println("aroundReturnBookLoggingAdvice: в библиотку успешно вернули книгу");


        return targetMethodResult;
    }
}
