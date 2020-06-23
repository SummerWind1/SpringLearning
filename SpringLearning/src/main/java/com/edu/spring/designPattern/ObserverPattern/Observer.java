package com.edu.spring.designPattern.ObserverPattern;

/**
 * 观察者的通用抽象类
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
