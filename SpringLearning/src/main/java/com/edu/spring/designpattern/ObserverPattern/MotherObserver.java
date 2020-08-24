package com.edu.spring.designpattern.ObserverPattern;

/**
 *
 */
public class MotherObserver extends Observer{

    // 把自己注册到被观察者中
    public MotherObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    public void update() {
        System.out.println("妈妈看到孩子哭");
    }
}
