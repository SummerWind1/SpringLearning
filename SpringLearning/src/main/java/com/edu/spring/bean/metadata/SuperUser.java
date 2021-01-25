package com.edu.spring.bean.metadata;

import org.springframework.beans.factory.FactoryBean;

public class SuperUser extends User {

    public String superUserName;

    public String getSuperUserName() {
        return superUserName;
    }

    public void setSuperUserName(String superUserName) {
        this.superUserName = superUserName;
    }
}
