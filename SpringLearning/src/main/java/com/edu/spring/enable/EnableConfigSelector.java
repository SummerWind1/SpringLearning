package com.edu.spring.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class EnableConfigSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 需要给一个类的全路径名称
        return new String[]{"com.edu.spring.enable.EnableConfig"};
    }
}
