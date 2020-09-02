package com.edu.spring.bean.metadata;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 *  @author fangpan
 *  @since 2020/8/24 12:39
 *  基于资源文件的 bean 元信息配置
 */
public class ResourceBeanMetaDataConfigurationDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        String location = "META-INF/user.properties";

        int i = beanDefinitionReader.loadBeanDefinitions(location);

        Object bean = beanFactory.getBean("user");
        System.out.println(bean);
    }
}
