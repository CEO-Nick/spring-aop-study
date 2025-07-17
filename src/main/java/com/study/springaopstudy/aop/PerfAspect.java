package com.study.springaopstudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {
    // 1. 해야할 일이 무엇인지 = advice
    // 2. 어디에 적용할 것인가 = pointcut

    // ProceedingJoinPoint는 Advice가 적용되는 대상 메서드 실행 자체 라고 보면 된다(여기서 SimpleEventService의 메서드 createEvent, publishEvent 등)
    // @Around는 Advice의 종류 중 하나로, 메서드 호출 전후에 실행되는 Advice를 의미
    // execution(* com.study.springaopstudy.aop.SimpleEventService.*(..))는 Pointcut 표현식으로, SimpleEventService 클래스의 모든 메서드에 적용됨
    // @annotation(PerfLogging)은 어노테이션 기반의 Pointcut 표현식으로, PerfLogging 어노테이션이 붙은 메서드에만 적용됨
    @Around("@annotation(PerfLogging)")
//    @Around("execution(* com.study.springaopstudy.aop.SimpleEventService.*(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    // 그냥 메서드 실행 이전에 실행하고 싶다면 @Before 어노테이션을 사용
    @Before("bean(simpleEventService)")
    public void hello() {
        System.out.println("Hello from PerfAspect!");
    }


    /*
     * 클라이언트 코드(AppRunner)와 실제 비즈니스 로직 코드(SimpleEventService) 수정 없이 부가적인 기능을 중복 코드 없이 추가할 수 있다.
     * + pointcut 수정을 통해 여러 클래스에도 적용할 수 있다.
     * 근데 deleteEvent는 적용 안하고 싶지만 적용되버린다 -> 이러면 어노테이션 기반으로 수정하면 된다
     */
}
