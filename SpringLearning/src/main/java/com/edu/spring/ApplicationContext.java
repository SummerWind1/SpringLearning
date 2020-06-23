package com.edu.spring;

import com.edu.spring.bean.SpringTestBean;
import com.edu.spring.bean.SpringTestBean1;
import com.edu.spring.designPattern.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringTestBean springTestBean = context.getBean(SpringTestBean.class);

        System.out.println(springTestBean.getName());

        SpringTestBean1 springTestBean1 = context.getBean(SpringTestBean1.class);

        System.out.println(springTestBean1.getName());

        User.builder().age(18).name("name").build();


    }

}
