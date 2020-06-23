package com.edu.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 这个processor 生效，还需要在配置文件中进行配置
 * <bean class="com.edu.spring.processor.CustomerBeanPostProcessor" />
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {

    /**
     *  bean 初始化之前的操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("bean name: "+beanName);
        return bean;
    }

    /**
     * bean 初始化之后的操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("bean name: "+beanName);
        return bean;
    }
}
