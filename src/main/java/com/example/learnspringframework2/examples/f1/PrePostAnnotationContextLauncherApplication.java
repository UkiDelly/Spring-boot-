package com.example.learnspringframework2.examples.f1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class SomeClass {

    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
    }

    // 의존성이 주입된 후에 어떠한 로직을 실행하게 하고 싶으면 @PostConstruct을 사용한다.
    // 의존성 주입이 완료되었을때 실행되며, 이 메소드는 클래스를 사용하기 전에 호출되어야한다.
    // 즉, 다른 Bean이 해당 Bean을 사용하기 전에 호출된다.
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    // 어플리케이션이 종료되기전, context에서 Bean이 삭제되기 전에
    // @PreDestory을 사용하요 뭔가를 할수 있다. 예) DB 연결 해제
    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up");
    }
}

@Component
class SomeDependency {

    public void getReady() {
        System.out.println("Some logic using SomeDependnency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }
}

