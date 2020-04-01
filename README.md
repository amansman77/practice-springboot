# Spring Boot 연습
Spring Boot를 연습하는 공간입니다.

## 개발 프레임워크
- IDE : STS-4.5.1.RELEASE
- Java : openjdk-12.0.1 (JavaSE-11)
- Springboot : 2.2.4.RELEASE
- Gradle : 6.0.1
- JUnit : 5.5.2

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

## Spring Security 예제

`com.ho.practice.springboot.security`에 구현

## Rest Client 예제

`com.ho.practice.springboot.restclient`에 구현

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


### 잘 동작하던 JUnit 테스트가 동작하지 않음

```java
java.lang.NoClassDefFoundError: org/junit/platform/engine/EngineDiscoveryListener
	at java.base/java.lang.ClassLoader.defineClass1(Native Method)
	at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1016)
	at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:151)
	at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:802)
	at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:700)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:623)
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:581)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	at org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.getLauncherDiscoveryListener(LauncherDiscoveryRequestBuilder.java:241)
	at org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder.build(LauncherDiscoveryRequestBuilder.java:235)
	at org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader.createFilteredTest(JUnit5TestLoader.java:70)
	at org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader.createTest(JUnit5TestLoader.java:64)
	at org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader.loadTests(JUnit5TestLoader.java:53)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:526)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
Caused by: java.lang.ClassNotFoundException: org.junit.platform.engine.EngineDiscoveryListener
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:583)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:178)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	... 18 more
```

해당 라이브러리를 확인해보니 `junit-platform-engine-1.5.2.jar`내에 해당 클래스가 존재하지 않는것을 확인하였고, `1.6`부터 `EngineDiscoveryListener`인터페이스가 추가된것을 확인함 [JUnit5 Docs](https://junit.org/junit5/docs/current/api/org.junit.platform.engine/org/junit/platform/engine/EngineDiscoveryListener.html)

해당 문제가 STS의 문제인지 확인해보기 위해 다음과 같이 테스트해본 결과
- Gradle Test로는 정상 동작함
- 신규 프로젝트의 빌드툴을 Gradle로 만들어서 확인하니 동일한 현상이 발생하는 것을 확인
- 신규 프로젝트의 빌드툴을 Maven으로 변경해서 확인하니 정상 동작함
- 이전 버전인 `STS-4.4.1.RELEASE`를 다운받아서 프로젝트를 새로 만드니 테스트가 수행되는것 확인
- 현재 버전인 `STS-4.6.0.RELEASE`, `Eclipse-2020-03`에서 다운받아서 프로젝트를 새로 만드니 동일한 오류가 발생하는 것을 확인
STS에 `Gradle`을 사용한 경우에 발생하는 것을 확인했고, STS의 버전업과 관련이 있는것을 확인

왜 업그레이드된 STS에서 `1.6`을 찾고 있지? STS에서 `JUnit`의 버전이 변경됐나?

구글링 결과, [EclipseでJUnit5がjava.lang.NoClassDefFoundError: org/junit/platform/engine/EngineDiscoveryListenerになる- Qiita](https://qiita.com/kagamihoge/items/54c48d2e928b652875a2)에서 제시한대로 `testRuntimeOnly 'org.junit.platform:junit-platform-launcher'`의존성을 추가했더니 정상 동작하는것을 확인

`junit-platform-launcher`의 버전을 `1.6.0`으로 변경하면 문제 상황이 동일하게 발생하는것을 확인하였으므로 junit의 launcher의 변경에 따른 문제로 볼 수 있음

STS의 버전별 차이점을 확인해보니 `eclipse plugins`에 존재하는 `org.junit.platform.launcher`의 버전 차이가 있다.
- `STS-4.4.1.RELEASE` :  `1.5.1`
- `STS-4.6.0.RELEASE` :  `1.5.1`, `1.6.0`
- `Eclipse-2020-03` :  `1.6.0`

이클립스가 JUnit을 구동하는 절차를 보면 다음과 같다.
- `org.eclipse.jdt.junit.runtime`플러그인에 있는 `org.eclipse.jdt.internal.junit.runner.RemoteTestRunner`클래스 구동
    - `org.eclipse.jdt.junit5.runtime`플러그인에 있는 `org.eclipse.jdt.internal.junit5.runner.JUnit5TestLoader`클래스를 의존관계로 가짐
    - `JUnit5TestLoader`클래스는 `org.junit.platform.launcher.Launcher`클래스를 의존관계로 가짐
    
- `junit-platform-launcher`라이브러리내의 `Launcher`클래스 load
    - 우선순위 : classpath -> eclipse plugins내 최신 버전

따라서 의존성을 추가하여 `classpath`에 `junit launcher`를 추가하여 해당 버전의 `launcher`를 사용할 수 있도록 한것임