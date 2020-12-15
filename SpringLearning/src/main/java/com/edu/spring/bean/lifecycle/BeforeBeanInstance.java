package com.edu.spring.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.util.ObjectUtils;

/**
 * bean 实例化前
 */
public class BeforeBeanInstance {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.addBeanPostProcessor(new MyInstanceBeanPostProcessor());

        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        beanDefinitionReader.register(BeforeBeanInstance.class);

        Object beforeBeanInstance = beanFactory.getBean("beforeBeanInstance");

        System.out.println("容器启动成功");

    }

    /**
     *  @author fangpan
     *  @since 2020/9/2 9:25
     *  bean 初始化前回调处理
     */
    static class MyInstanceBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

        // bean 实例化前操作
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("beforeBeanInstance", beanName)) {
                System.out.println("bean 初始化前回调");
            }
            return null;
        }

        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            return false;
        }

    }


}
