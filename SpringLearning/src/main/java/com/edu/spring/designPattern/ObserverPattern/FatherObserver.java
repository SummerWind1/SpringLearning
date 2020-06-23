package com.edu.spring.designPattern.ObserverPattern;

/**
 *
 */
public class FatherObserver extends Observer{

    // 把自己注册到被观察者中
    public FatherObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    public void update() {
        System.out.println("爸爸看到孩子哭");
    }
}
