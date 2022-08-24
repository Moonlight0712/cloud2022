package com.lay.springcloud;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.annotation.Annotation;

/**
 * @author Dragon code!
 * @create 2022-07-17 17:44
 */
public class SpringbootException implements ControllerAdvice {
    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public String[] basePackages() {
        return new String[0];
    }

    @Override
    public Class<?>[] basePackageClasses() {
        return new Class[0];
    }

    @Override
    public Class<?>[] assignableTypes() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation>[] annotations() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
