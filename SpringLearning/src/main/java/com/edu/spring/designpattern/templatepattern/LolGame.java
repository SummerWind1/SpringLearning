package com.edu.spring.designpattern.templatepattern;

public class LolGame extends Game{

    @Override
    public void initGameData() {
        System.out.println("lol 初始化");
    }

    @Override
    public void startGame() {
        System.out.println("lol 开始游戏");
    }

    @Override
    public void endGame() {
        System.out.println("lol 结束游戏");

    }
}
