package com.edu.spring.designPattern.ObserverPattern;


import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式被观察的对象
 */
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    public void register(Observer observer) {
        observers.add(observer);
    }


    public void cry() {
        notifyObserver();
    }

    /**
     * 通知观察者
     */
    private void notifyObserver() {

        for (Observer observer : observers) {
            observer.update();
        }
    }

    public static void main(String[] args) {

        Subject subject = new Subject();
        // 通过new 将观察者注册到 被观察者对象的集合中
        Observer fatherObserver = new FatherObserver(subject);
        Observer motherObserver = new MotherObserver(subject);

        subject.cry();
    }

}
