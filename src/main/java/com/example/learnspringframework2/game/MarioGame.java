package com.example.learnspringframework2.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


// @Primary를 사용하면 같은 타입의 Bean이 있을 경우 우선권을 줄 수 있다.
@Component
@Primary
public class MarioGame implements GamingConsole {

    // 생성자
    public MarioGame() {

    }


    public void up() {
        System.out.println("Mario is Jumping up");
    }

    public void down() {
        System.out.println("Mario is Going down");
    }

    public void left() {
        System.out.println("Mario is Going left");
    }

    public void right() {
        System.out.println("Mario is Going right");
    }
}
