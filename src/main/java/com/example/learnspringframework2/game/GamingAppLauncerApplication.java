package com.example.learnspringframework2.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring Bean을 동적을 생성하는 방법
@Configuration
// 패키지를 지정해서 어떤 패키지를 검색할지 알려줄 수 있다
// 즉 PacmanGame이 있는 패키지
@ComponentScan("com.example.learnspringframework2.game")
public class GamingAppLauncerApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingAppLauncerApplication.class);

        // 여기서 오류 발생, Spring은 GameConsole의 구현체를 검색하려고 하지만, 구현체인 PacmanGame이 어디 있는지 찾지 못하는 상황
        // @ComponentScan을 사용하면 Spring에게 어떤 패키지를 검색할지 알려줄수 있다.
        // @ComponenScan을 사용해서 패키지를 지정하면 비로소 오류 없이 PacmanGame을 찾을수 있다.
        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();
    }


    //
}


