package com.study.springaopstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopStudyApplication {

    public static void main(String[] args) {
        // Spring Boot 애플리케이션을 실행할 때 웹 서버 안띄우는 방법
        SpringApplication app = new SpringApplication(SpringAopStudyApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
