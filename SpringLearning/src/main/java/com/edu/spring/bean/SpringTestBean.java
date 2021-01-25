package com.edu.spring.bean;

import com.edu.spring.bean.metadata.User;
import com.edu.spring.bean.service.UserService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

// bean 初始化后，bean 被销毁前
//@Component
// , FactoryBean
public class SpringTestBean implements InitializingBean, DisposableBean {

    public SpringTestBean() {

    }

    public SpringTestBean(Date now) {
        this.now = now;
    }

    //    public SpringTestBean(String name) {
//        this.name = name;
//    }
//
//
//    // 集合注入
//    private List<String> books;
//
//    public List<String> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<String> books) {
//        this.books = books;
//    }
//
    // 对象注入
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //
//    // 集合对象注入
//    private List<User> users;
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//
    // 普通属性注入
    private String name;

    public String getName() {
        return name;
    }

    // 时间格式参数的注入
    private Date now;

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public void setName(String name) {
        this.name = name;
    }

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //    // 同类型对象注入
//    private List<UserService> userServices;

//    public void setUserServices(List<UserService> userServices) {
//        this.userServices = userServices;
//    }

//    public List<UserService> getUserServices() {
//        return userServices;
//    }

    public void destroy() throws Exception {
        System.out.println("bean 销毁操作");
    }

    // 这个可以改变populate 阶段给对象注入的值
    public void afterPropertiesSet() throws Exception {
        name = "bean 初始化 赋值";
        System.out.println(name);

        System.out.println("afterPropertiesSet V1");
    }

    // 该操作在afterPropertiesSet()方法之后执行， 需要在xml 文件中指定initMethod
    public void initMethod() {

        System.out.println("bean 初始化操作");

        System.out.println("afterPropertiesSet V2");

    }

    public void destroyMethod() {

        System.out.println("bean 销毁操作");

    }

    public Object getObject() throws Exception {
        return null;
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }


}
