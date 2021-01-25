package com.edu.rpcdemo.provider;

import com.edu.rpcdemo.api.IRpcHelloService;

public class IRpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "hello" + name + "!";
    }
}
