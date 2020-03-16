# Spring Boot 연습
Spring Boot를 연습하는 공간입니다.

## 개발 프레임워크
- IDE : STS-4.5.1.RELEASE
- Java : openjdk-12.0.1 (JavaSE-11)
- JUnit : Jupiter
- Gradle : 6.0.1

## Properties 예제

`com.ho.practice.springboot.properties`에 구현

## Test 예제

`com.ho.practice.springboot.test`에 구현

## Web MVC 예제

`com.ho.practice.springboot.webmvc`에 구현

예제 목록
- HATEOAS
- HTML Unit : HTML의 테스트를 다양하게 할 수 있도록 지원
- ...

## Spring data 예제

`com.ho.practice.springboot.data`에 구현

## Troubleshooting

### JUnit 테스트 환경에서 Test resource가 동작하지 않음

1. gradle build를 수행하면 Test resource를 적용하여 unit test가 통과하는것을 확인
2. 빌드 툴을 Maven으로 설정한 후 STS에서 unit test를 수행하면 Test resource가 적용되는것을 확인

여기까지 STS에서 Gradle을 활용한 프로젝트 구조에서 Test resource를 읽어 오지 못한다고 판단

IDE에서 Test run할 때, JUnit말고 Gradle test를 사용하니 원하는 결과가 나왔음

하지만 Maven을 사용할 때와 동일하게 JUnit test를 사용할 수는 없을까?

1. JUnit을 실행하는 Command Line을 확인하니 Maven과 Gradle프로젝트에서 Test와 Classes의 순서가 다른것을 확인
2. `-classpath`옵션에 Maven은 `test-classes`가 가장 먼저 들어오지만 Gradle은 `bin\main`이 먼저 설정된것을 확인
3. Gradle프로젝트에서 JUnit으로 테스트를 진행할 때 `bin\main\resources\application.properties`를 삭제했더니 원하는 결과가 나왔음

여기까지 `-classpath`옵션의 설정 순서에 영향이 있을 것으로 판단

`bin\main`의 Output folder를 default로 설정하니 `-classpath`옵션에 `bin\test`가 먼저 설정되고 Test resource를 읽어오는것을 확인했음


