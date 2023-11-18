package com.example.learnspringframework2.game;

import org.springframework.stereotype.Component;


// @Component 어노테이션을 사용하면 Spring이 알아서 Bean으로 만들어준다.
//
@Component
public class PacmanGame implements GamingConsole {

    public PacmanGame() {

    }

    @Override
    public void up() {
        System.out.println("Up");
    }

    @Override
    public void down() {
        System.out.println("Down");
    }

    @Override
    public void left() {
        System.out.println("Left");
    }

    @Override
    public void right() {
        System.out.println("Right");
    }
}
