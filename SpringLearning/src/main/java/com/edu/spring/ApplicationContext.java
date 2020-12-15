package com.edu.spring;

import com.edu.spring.bean.SpringTestBean;
import com.edu.spring.enable.EnableDemoAnnotation;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@EnableDemoAnnotation
public class ApplicationContext {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringTestBean springTestBean = context.getBean(SpringTestBean.class);

        System.out.println(springTestBean.getName());
        System.out.println(springTestBean.getNow());
        System.out.println(springTestBean.getUserService().toString());
//        System.out.println(springTestBean.getBooks());
        System.out.println(springTestBean.getUser());
//        System.out.println(springTestBean.getUsers());
//        System.out.println(springTestBean.getUserServices().toString());

//        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationContext.class);




    }

}
