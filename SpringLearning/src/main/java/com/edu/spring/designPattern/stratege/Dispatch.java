package com.edu.spring.designPattern.stratege;

/**
 * 统一的入口，不同的实现类有不同的实现
 *
 * 策略模式和桥接模式相似，但是桥接模式更复杂
 *
 */
public class Dispatch {

    private StrategyPattern strategyPattern;

    public Dispatch (StrategyPattern strategyPattern) {
        this.strategyPattern = strategyPattern;
    }

    public void execute(){
        strategyPattern.eat();
    }


    public static void main(String[] args) {

        Dispatch dispatch = new Dispatch(new ChildStrategy());
        dispatch.execute();

    }

}
