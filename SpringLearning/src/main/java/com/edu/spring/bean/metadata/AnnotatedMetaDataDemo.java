package com.edu.spring.bean.metadata;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 *  @author fangpan
 *  @since 2020/8/25 9:24
 *  基于注解加载 bean 的元信息
 */
public class AnnotatedMetaDataDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        beanDefinitionReader.register(AnnotatedMetaDataDemo.class);

        AnnotatedMetaDataDemo annotatedMetaDataDemo = (AnnotatedMetaDataDemo) beanFactory.getBean("annotatedMetaDataDemo");

        System.out.println(annotatedMetaDataDemo);

    }


}
