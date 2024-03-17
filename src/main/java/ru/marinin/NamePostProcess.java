package ru.marinin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class NamePostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            Field field = bean.getClass().getDeclaredField("name");
            field.setAccessible(true);
            if (field.get(bean) == null)
                field.set(bean, "Vasya");
        } catch (NoSuchFieldException e) {

        } catch (IllegalAccessException e) {

        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
