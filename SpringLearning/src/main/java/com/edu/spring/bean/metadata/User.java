package com.edu.spring.bean.metadata;


import com.edu.spring.bean.SpringTestBean;

public class User {

    private String id;

    private String name;

    private SpringTestBean springTestBean;

    public SpringTestBean getSpringTestBean() {
        return springTestBean;
    }

    public void setSpringTestBean(SpringTestBean springTestBean) {
        this.springTestBean = springTestBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
