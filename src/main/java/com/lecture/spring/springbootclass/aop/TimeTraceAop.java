package com.lecture.spring.springbootclass.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
// AOP 적용을 위한 어노테이션
@Aspect
// springConfig 파일에 따로 등록해 사용할 수 있고 Component 어노테이션도 사용 가능
//@Component
public class TimeTraceAop {
    // Target을 지정하기 위한 어노테이션 (SpringConfig 파일을 제외시키지 않으면 순환에러 발생)
    @Around("execution(* com.lecture.spring.springbootclass..*(..)) && !target(com.lecture.spring.springbootclass.SpringConfig)")
    public Object exeute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start" + joinPoint.toLongString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("End = " + joinPoint.toString() + " " + timeMs);
        }
    }
}

// AOP를 적용하기 위한 어노테이션

