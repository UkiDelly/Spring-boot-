package com.example.learnspringframework2.game;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {


    private final GamingConsole game;


    // @Primary로 우선권이 있는 상태에서 특정 상황에서 특정 bean을 연결하려면 @Qualifier를 사용한다.
    // 그게 없으면 자동으로 @Primary를, @Primary가 없다면 Bean에 등록된 것을 사용한다.
    // @Qualifier는 한정자를 의미한다.
    public GameRunner(@Qualifier("SuperContraGame") GamingConsole game) {
        this.game = game;
    }


    public void run() {

        System.out.println("Starting the game: " + game.getClass().getSimpleName());

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
