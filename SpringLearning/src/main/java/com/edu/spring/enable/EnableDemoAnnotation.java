package com.edu.spring.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 三种方式注入需要的配置信息
//@Import(EnableConfig.class)
//@Import(EnableConfigSelector.class)
@Import(EnableConfigImportBeanDefinitionRegistry.class)
public @interface EnableDemoAnnotation {

}
