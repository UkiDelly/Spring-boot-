package com.example.learnspringframework2.examples.a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


// Lazy Initialization

@Component
class ClassA {
}

@Component
@Lazy
class ClassB {
    // @Lazy 어노테이션을 사용하면 초기화를 지연시킬수 있다. 즉 Spring이 시작될때 초기화하는것이 아닌
    // 해당 Bean을 사용하는 시점에 초기화가 된다/

    private final ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        System.out.println("Some Initialization logic");
        this.classA = classA;
    }


    public void doSomething() {
        System.out.println("Do Something");
    }
}


@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);

        //for (String beanName : context.getBeanDefinitionNames()) {
        //    System.out.println(beanName);
        //}

        System.out.println("Initailization of Context is completed.");

        context.getBean(ClassB.class).doSomething();
    }
}
