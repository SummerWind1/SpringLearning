package com.edu.spring;

import com.edu.spring.bean.SpringTestBean;
import com.edu.spring.bean.metadata.User;
import com.edu.spring.bean.metadata.UserHolder;
import com.edu.spring.enable.EnableDemoAnnotation;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

@EnableDemoAnnotation
@EnableAspectJAutoProxy
public class ApplicationContext {

    public static void main(String[] args) throws IntrospectionException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SpringTestBean springTestBean = context.getBean(SpringTestBean.class);

        System.out.println(context.getBean(User.class).getSpringTestBean().toString());
        System.out.println(springTestBean.toString());

        System.out.println(context.getBean(User.class).getSpringTestBean().getUser().getSpringTestBean());

//        System.out.println(springTestBean.getName());
//        System.out.println(springTestBean.getNow());
        System.out.println(springTestBean.getUserService().toString());
//        System.out.println(springTestBean.getBooks());
        System.out.println(springTestBean.getUser());
//        System.out.println(springTestBean.getUsers());
//        System.out.println(springTestBean.getUserServices().toString());

//        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationContext.class);

        UserHolder userHolder = context.getBean(UserHolder.class);

        System.out.println(userHolder.getUser());


        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);


    }

}
