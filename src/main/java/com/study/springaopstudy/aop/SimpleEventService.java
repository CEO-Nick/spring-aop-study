package com.study.springaopstudy.aop;

import org.springframework.stereotype.Service;

// Real Subject
@Service
public class SimpleEventService implements EventService {

    @PerfLogging
    @Override
    public void createEvent() {
        // 이 코드가 cross-cutting concern 이다.
//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Creating event...");

        // 이 코드가 cross-cutting concern 이다.
//        System.out.println(System.currentTimeMillis() - begin);
    }

    @PerfLogging
    @Override
    public void publishEvent() {
        // 이 코드가 cross-cutting concern 이다.
//        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Publishing event...");

        // 이 코드가 cross-cutting concern 이다.
//        System.out.println(System.currentTimeMillis() - begin);
    }

    @Override
    public void deleteEvent() {
        System.out.println("Deleting event...");
    }

}
