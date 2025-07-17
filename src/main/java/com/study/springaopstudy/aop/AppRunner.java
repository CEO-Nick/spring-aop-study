package com.study.springaopstudy.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// client 코드
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    EventService eventService;  // @Primary가 붙은 ProxySimpleEventService가 주입됨

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventService.createEvent();
        eventService.publishEvent();
        eventService.deleteEvent();
    }
}
