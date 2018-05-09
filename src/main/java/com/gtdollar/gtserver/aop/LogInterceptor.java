package com.gtdollar.gtserver.aop;



import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInterceptor {

    private static Logger log = Logger.getLogger( LogInterceptor.class );

    public LogInterceptor() {
    }

    @Pointcut("execution( * com.gtdollar.gtserver.controller.*.*(..))")
    private void selectAll() { }

    @Before("selectAll()")
    public void beforeAdvice( JoinPoint joinPoint ) {

        /*log.info(  "beforeAdvice() " + joinPoint.getArgs()
                + "  " + joinPoint.getKind()
                + "  " + joinPoint.getClass()
                + "  " + joinPoint.getSignature()
                + "  " + joinPoint.getSourceLocation()
                + "  " + joinPoint.getStaticPart()
                + "  " + joinPoint.getTarget()
                + "  " + joinPoint.getThis() );*/
        for( Object obj: joinPoint.getArgs() ) {
            log.info( " " + obj);
        }
    }


    @After("selectAll()")
    public void afterAdvice() {

        log.info(  "afterAdvice() " );
    }




}
