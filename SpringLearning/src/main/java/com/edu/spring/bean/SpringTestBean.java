package com.edu.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
// bean 初始化后，bean 被销毁前
public class SpringTestBean implements InitializingBean, DisposableBean {

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void destroy() throws Exception {
        System.out.println("bean 销毁操作");
    }

    public void afterPropertiesSet() throws Exception {
        name = "bean 初始化 赋值";
        System.out.println(name);
    }

    // 该操作在afterPropertiesSet()方法之后执行
    public void initMethod() {

        System.out.println("bean 初始化操作");

    }

    public void destroyMethod() {

        System.out.println("bean 销毁操作");

    }
}
