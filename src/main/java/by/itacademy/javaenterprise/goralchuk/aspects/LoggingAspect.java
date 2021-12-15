package by.itacademy.javaenterprise.goralchuk.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j(topic = "/ ASPECT")
@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(* by.itacademy.javaenterprise.goralchuk.services.BookService.findAllBookFromDatabase())")
    public void performanceOne() {
    }

    @Before("performanceOne()")
    public void beforeFindAllBookFromDatabase() {
        log.debug("1-BEFORE method: Now all the books are appearing {}... --->", LocalDateTime.now());
    }

    @After("performanceOne()")
    public void afterFindAllBookFromDatabase() {
        log.debug("1-AFTER method: All books have already been received {}... <---", LocalDateTime.now());
    }

    @Pointcut("execution(* by.itacademy.javaenterprise.goralchuk.services.BookService.*(..))")
    public void performanceTwo() {
    }

    @AfterReturning(pointcut = "performanceTwo()", returning = "returned")
    public void afterReturningAdvice(JoinPoint jp, Object returned) {
        log.debug("2-AFTER returning: {} / {}", returned, jp.getSignature());
    }

    @AfterThrowing(pointcut = "performanceTwo()",
            throwing = "e")
    public void afterThrowingAdvice(JoinPoint jp, Throwable e) {
        log.debug("3-AFTER Throwing: {}", jp.getSignature(), e);
    }

    @Pointcut("execution(* by.itacademy.javaenterprise.goralchuk.services.BookService.findFilterBookByAllParameters(String, String, String))")
    public void performanceThree() {
    }

    @Around("performanceThree()")
    public void aroundMethod(ProceedingJoinPoint joinPoint) {
        try {
            log.info("4 - Start {}", LocalDateTime.now());
            Object result = joinPoint.proceed();
            log.info("4 - Finish time: {}", LocalDateTime.now());
            log.info("ResultOfMethodWithArguments: " + result);
        } catch (Throwable throwable) {
            log.info(throwable.toString());
        }
    }
}
