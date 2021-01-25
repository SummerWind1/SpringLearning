package com.edu.rpcdemo.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * 网络协议相关
 */
@Data
public class InvokeProtocol implements Serializable {

    // 类名称
    private String classname;

    // 方法名称
    private String methodName;

    // 参数类型
    private Class<?> params;

    // 参数值
    private Object [] values;


}
