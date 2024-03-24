package ru.marinin.defaultPackage;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class DefaultPostProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext applicationContext;
    Map<String, Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(DefaultAnnotation.class)) {
            beans.put(beanName, bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beans.containsKey(beanName)) {
            defaultInject(beans.get(beanName));
        }
        beans.remove(beanName);
        return bean;
    }


    private void defaultInject(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        Object resetBean = applicationContext.getBean(bean.getClass().getAnnotation(DefaultAnnotation.class).value());
        Method[] methods = resetBean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getReturnType());
        }
        System.out.println(resetBean);
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("TYPE: " + field.getType());
            try {
                field.set(bean, findMethod(methods, field).invoke(resetBean));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    Method findMethod(Method[] methods, Field field) {
        for (Method method : methods) {
            if (method.getReturnType() == field.getType()) return method;
        }
        return null;
    }
}
