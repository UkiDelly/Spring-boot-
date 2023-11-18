package com.example.learnspringframework2.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
// @Primary가 있는 상황에서 특정 상황일때만 우선권을 부여해주고 싶을때는 @Qualifier를 사용한다
// @Qualifier는 한정자를 의미한다.
@Qualifier("SuperContraGame")
public class SuperContraGame implements GamingConsole {

    public SuperContraGame() {

    }


    public void up() {
        System.out.println("SuperContraGame Up");
    }

    public void down() {
        System.out.println("SuperContraGame Sit");
    }

    public void left() {
        System.out.println("SuperContraGame Go Back");
    }

    public void right() {
        System.out.println("SuperContraGame Shoot a bullet");
    }
}
