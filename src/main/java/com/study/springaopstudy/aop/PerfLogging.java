package com.study.springaopstudy.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 이 어노테이션을 사용하면 성능을 로깅해 줍니다.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)    // 이 어노테이션 정보를 얼마나 유지할 것인가
public @interface PerfLogging {

}
