package com.example.learnspringframework2.examples.e1;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// 평범한 Bean
@Component
class NormalClass {

}


// Bean에 스코프를 지정하고 싶을때는 @Scope 어노테이션을 사용한다.
// 이때 value로 스코프를 지정해줄수 있다.
// 이 class는 프로토타입 클래스이므로 ConfigurableBeanFactory.SCOPE_PROTOTYPE 스코프를 지정한다.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);


        // Bean은 기본적으로 싱글톤 클래스이다. 그래서 여러번 같은 Bean을 호출해도 해시값은 달라지지 않는다.
        System.out.println(context.getBean(NormalClass.class));
        System.out.println(context.getBean(NormalClass.class));
        System.out.println(context.getBean(NormalClass.class));

        // 하지만 @Scope + Prototype으로 지정한 클래스는 호출할때마다 새로운 인스턴스를 생성한다.
        // 즉 싱글톤 클래스가 아니다.
        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));
    }
}

