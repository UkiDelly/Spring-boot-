# Bean

## @Bean

`@Bean` 어노테이션은 `@Configuration`어노테이션이 있는 Spring Configuration class 안에 메소드에만 지정해줄수 있다.

## @Component

`@Component` 어노테이션으 모든 Java 객체에 사용이 가능한 어노테이션이며 마찬가지로 `Bean`을 생성해준다.

`@Component`는 `@Bean`보다 사용하기 쉽다. 그 이유는 클래스에 `@Component` 어노테이션만 추가하면 Spring에서 알아저 Bean으로 등록해주기 때문이다. 하지만 `@Bean`은 좀 더
복잡하다. 그 이유는 Bean을 만들기 위해서 직접 작성해야하기 때문이다.
********

## @Autowired

1. Field-Injection
2. Constructor-Injection
    - `@Autowired` 어노테이션을 필수로 지정해주지 않아도 Spring에서 알아서 DI 해준다.
3. Setter-Injection

## @Component vs @Bean

| Heading    | `@Component`              | `@Bean`                                            |
|:-----------|---------------------------|----------------------------------------------------|
| 사용 가능한 곳   | 모든 Java 객체                | Spring Configuration class                         |
| 사용 난이도     | 매우쉬움                      | 복잡                                                 |     
| AutoWiring | Field, Setter Constructor | methot call, mehtod parameter                      |
| Bean 생성 주체 | Spring Framework          | 프로그래머                                              |
| 권장사항       | 대부분의 상황에 권장됨              | Bean을 생성할때 커스텀 로직이 필요할때, 서드파티 라이브러리를 Bean으로 등록할때 등 |

---

## 초기화 지연

기본적으로 `Bean`은 스프링이 시작하게 되면 즉시 초기화된다. 하지만 `@Lazy` 어노테이션을 사용하면 초기화를 스프링이 시작한 시점이 아닌 해당 `Bean`을 호출할때 초기화하게 된다. `@Lazy`
어노테이션을 사용하게 되면 에러는 런타임에서 발생하게 된다. 즉, 스프링이 시작될때 오류를 발생시키지 않는다.

### 특징

1. 런타입에 오류가 발생한다. <br>
    - 런타임에 오류가 발생하기 때문에 스프링이 시작할때 오류 때문에 멈추지 않는다. <br>
2. 드믈게 사용한다. <br>
    - 스프링은 즉시 초기화를 권장한다.
3. 메모리 관리가 용이하다. <br>
    - 즉시 초기화는 스프링이 시작할때 모두 로드하기 때문에 메모리 사용량이 높지만 지연 초기화의 경우 호출하기 전까지는 메모리를 차지 하지 않는다.

---

## Scope

스프링은 `Bean`을 생성할때 두가지 Scope가 존재한다. `Singleton`과 `Prototype` 스코프이다. 기본적으로 모든 Bean은 Singleton 스코프인다. 하지만 `@Scope` 어노테이션을
사용하면, Bean의 스코프를 변경할수 있다.

Singleton Bean은 몇번을 호출해도 해시값이 동일하다. 즉, 한개의 인스턴스를 가지고 있다. 하지만 `@Scope` 어노테이션을 사용해서 스코프를 `Prototype`으로 변경하면 Bean을 호출할때마다
새로운 인스턴스를 생성한다.

싱글톤, 프로토타입 이외에도 웹 애플리케이션에서만 적용되는 스코프가 있다. `web-aware ApplicationContext`이라고 불리며 다음과 같이 있다.

1. `Request` <br>
    - HTTP 요청당 하나의 인스턴스를 가지고 있다. <br>

2. `Session` <br>
    - HTTP 세션당 하나의 인스턴스를 가지고 있다. <br>

3. `Application` <br>
    - 어플리케이션당 하나의 인스턴스를 가지고 있다. <br>

4. `WebSocket`
    - 웹소켓 인스턴스당 하나의 인스턴스를 가지고 있다.

### `Java` 싱글톤 vs `Spring Singleton`

`Java`의 싱글톤을 디자인 패턴이다. 또한 `JVM`당 하나의 인스턴스를 의미한다. 하지만 `Spring Singleton`은 스프링 IoC 컨테이너당 하나의 인스턴스를 갖는것이다.

JVM에 Spring IoC 컨테이너가 하나만 돌아가고 있을때는 Java 싱글톤과 Spring 싱글톤은 같은 의미지만. JVM에 여러개의 Spring IoC 컨테이너가 존재한다면 Java 싱글톤 != Spring
싱글톤이 된다. 하지만 보통 JVM에 여러개의 Spring IoC 컨테이너가 작동하지 않는다.

`Prototype`은 대부분의 상황에서 쓰이지 않는다. 하지만 상태가 있는 Bean이 필요한 경우에는 사용한다.

---

## `PreConstruct`과 `PreDestroy`

스프링 Bean이 주입되고 나서 특정한 로직을 실행하고 싶을때, `예) 디비 연결` 함수에 `@PreConstruct` 어노테이션을 추가하게 되면, 해당 Bean을 다른 Bean이 사용하기 전에 호출된다.

반대로 스프링이 종료할떄 또는 Bean이 삭제될때, 삭제하기 전에 특정한 로직 `예) 디비 연결 해제`을 실행하고 싶을때 함수에 `@PreDestory` 어노테이션을 사용하면, Bean이 삭제 되기 전에 해당 로직을
실행한다.