package com.edu.spring.bean;

import com.edu.spring.bean.service.UserService;
import com.edu.spring.bean.service.impl.UserServiceImpl;
import com.edu.spring.bean.service.impl.UserServiceImpl2;

public class BeanCreationFactory {

    private UserServiceImpl userService = new UserServiceImpl();

    private UserServiceImpl2 userServiceImpl2 = new UserServiceImpl2();

    public UserServiceImpl instanceUserServiceImpl() {
        return this.userService;
    }

    public UserServiceImpl2 instanceUserServiceImpl2() {
        return this.userServiceImpl2;
    }

}
