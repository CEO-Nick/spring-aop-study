# Spring AOP Study

Spring AOP(Aspect-Oriented Programming)를 학습하기 위한 예제 프로젝트입니다.

## 프로젝트 개요

이 프로젝트는 횡단 관심사(Cross-cutting Concerns)를 처리하는 방법의 발전 과정을 보여줍니다:
1. 직접적인 코드 작성 (중복 코드 발생)
2. 프록시 패턴 적용
3. Spring AOP를 통한 최종 해결

## 기술 스택

- Java 17
- Spring Boot 3.5.3
- Spring AOP
- Gradle

## 주요 구성 요소

### 1. 기본 인터페이스 및 구현체
- `EventService`: 이벤트 처리를 위한 기본 인터페이스
- `SimpleEventService`: 실제 비즈니스 로직을 구현한 서비스 클래스

### 2. 프록시 패턴 구현
- `ProxySimpleEventService`: 성능 측정 기능을 추가한 프록시 클래스 (현재 비활성화)

### 3. AOP 구현
- `@PerfLogging`: 성능 측정을 위한 커스텀 어노테이션
- `PerfAspect`: 실제 AOP 로직을 구현한 Aspect 클래스

### 4. 실행 클래스
- `AppRunner`: 애플리케이션 실행 및 테스트를 위한 클래스

## AOP의 핵심 개념

### Advice 종류
- `@Around`: 메서드 실행 전후에 동작
- `@Before`: 메서드 실행 전에 동작

### Pointcut 표현식
- `@annotation(PerfLogging)`: 특정 어노테이션이 붙은 메서드에만 적용
- `execution(* 패키지.클래스.*(..))`: 특정 클래스의 모든 메서드에 적용
- `bean(빈이름)`: 특정 빈의 모든 메서드에 적용

## 실행 방법

```bash
./gradlew bootRun