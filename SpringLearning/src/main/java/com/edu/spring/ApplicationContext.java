package com.edu.spring;

import com.edu.spring.enable.EnableDemoAnnotation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableDemoAnnotation
public class ApplicationContext {

    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        SpringTestBean springTestBean = context.getBean(SpringTestBean.class);
//
//        System.out.println(springTestBean.getName());
//
//        SpringTestBean1 springTestBean1 = context.getBean(SpringTestBean1.class);
//
//        System.out.println(springTestBean1.getName());
//
//        User.builder().age(18).name("name").build();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ApplicationContext.class);

        context.refresh();

        String getHelloEnable = (String)context.getBean("getHelloEnable");

        System.out.println(getHelloEnable);

        context.start();

    }

}
