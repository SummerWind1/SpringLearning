package com.edu.spring.awarebean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * 实现aware 接口的回调
 */
public class MyBeanAwareTest implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

    private List<String> books;

    private String testName;

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }


    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("MyBeanAwareTest setBeanClassLoader V1");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanAwareTest setBeanFactory V2");
    }

    public void setBeanName(String name) {
        System.out.println("MyBeanAwareTest setBeanName V3");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("MyBeanAwareTest setApplicationContext V4");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("MyBeanAwareTest setApplicationEventPublisher V5");
    }

    public void setEnvironment(Environment environment) {
        System.out.println("MyBeanAwareTest setEnvironment V6");
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("MyBeanAwareTest setResourceLoader V7");
    }

    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("MyBeanAwareTest setImportMetadata V8");
    }



}
