package com.edu.spring.bean;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 使用注解来指定bean的init 和 destroy 方法
 * 需要开启配置
 * <bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor" />
  */

public class SpringTestBean1 {

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("bean1 销毁操作");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        name = "bean1 初始化 赋值";
        System.out.println(name);
    }
}
