package com.edu.spring.designpattern.templatepattern;

public abstract class Game {


    public void initGameData(){

        System.out.println("游戏环境初始化");
    }

    public abstract void startGame();
    public void endGame(){
        System.out.println("游戏结束");
    }


    public static void main(String[] args) {

        Game game = new LolGame();

        game.endGame();

        game.startGame();

    }

}
