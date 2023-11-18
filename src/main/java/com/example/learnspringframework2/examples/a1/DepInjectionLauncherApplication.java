package com.example.learnspringframework2.examples.a1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// DI - Dependency Injection

@Configuration
// @ComponentScan에 패키지명을 지정해주지 않을경우, 현재 패키지를 스캔한다.
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);

        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }


        System.out.println(context.getBean(YourBusinessClass.class));
    }
}


// YourBusinessClass
@Component
class YourBusinessClass {

    // 자동으로 Spring에서 DI를 하게 해주려면 @Autowired를 사용한다.
    // 생성자나 수정자에 전달한데 아니고 필드에 지정되었기 때문에 Field Injection이다
    //@Autowired
    Dependency1 dependency1;
    //@Autowired
    Dependency2 dependency2;


    // Constructor injection
    //  생성자 주입
    // 생성자에 Autowired를 사용한다.
    public YourBusinessClass(@Autowired Dependency1 dependency1, @Autowired Dependency2 dependency2) {
        System.out.println("Constructor Injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // setter injection
    // setter에 @Autowired를 사용한다.
    //@Autowired
    //public void setDependency1(Dependency1 dependency1) {
    //    System.out.println("Setter Injection - dependency1");
    //    this.dependency1 = dependency1;
    //}
    //
    //@Autowired
    //public void setDependency2(Dependency2 dependency2) {
    //    System.out.println("Setter Injection - dependency2");
    //    this.dependency2 = dependency2;
    //}
 

    // 가장 추천하는 방식은 생성자 주입(Contructor Injection)이다.
    // 그 이유중 하나는 @Authwired를 사용하지 않아도 되기 때문이다.


    public String toString() {
        return "YourBusinessClass(dependency1=" + dependency1 + ", dependency2=" + dependency2 + ")";
    }

}

// Dependency1
@Component
class Dependency1 {

    @Override
    public String toString() {
        return "Dependency1";
    }
}

// Dependency2
@Component
class Dependency2 {

    @Override
    public String toString() {
        return "Dependency2";
    }
}