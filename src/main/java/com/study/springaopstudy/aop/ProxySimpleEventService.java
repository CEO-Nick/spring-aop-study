package com.study.springaopstudy.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
//@Service
public class ProxySimpleEventService implements EventService {

//    @Autowired
    private SimpleEventService simpleEventService;

    @Override
    public void createEvent() {
        // 시간 재는 기능을 여기서 구현
        long begin = System.currentTimeMillis();
        simpleEventService.createEvent();   // 위임
        System.out.println("Execution time: " + (System.currentTimeMillis() - begin) + " ms");
    }

    @Override
    public void publishEvent() {
        long begin = System.currentTimeMillis();
        simpleEventService.publishEvent();
        System.out.println("Execution time: " + (System.currentTimeMillis() - begin) + " ms");
    }

    /*
     * 이렇게 구현하면 원래 클래스(SimpleEventService) 안건드리고, 클라이언트(AppRunner) 코드도 안건드리고 부가 기능 추가 가능함
     * 근데 여기서도 begin, end 시간 재는 코드가 중복됨
     * 이렇게 직접 클래스를 만드는 비용과 수고(내가 직접 위임처리 해야 함)
     * 다른 클래스들에도 이런 기능 만들고 싶으면 또 만들어야 함
     * 그래서 AOP를 사용함
     * AbstractAutoProxyCreateor가 기존 빈(SimpleEventService)을 감싸서 프록시 객체(ProxySimpleEventService)를 만들어주고, 그걸 빈으로 등록함
     * 즉, 내가 직접 ProxySimpleEventService 클래스를 만들 필요가 없음
     */


    @Override
    public void deleteEvent() {
        simpleEventService.deleteEvent();
    }

}
