package ru.marinin.toString;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;
import ru.marinin.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class ToStringPostProcessor implements BeanPostProcessor {

    Map<String, Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ToString.class)) {
            beans.put(beanName, bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beans.containsKey(beanName)) {
            return toStringInject(beans.get(beanName));
        }

        return bean;
    }


    private Object toStringInject(Object bean) {


        ClassLoader originalClassLoader = bean.getClass().getClassLoader();
        Class[] interfaces = bean.getClass().getInterfaces();
        ToStringable proxy = (ToStringable) Proxy.newProxyInstance(originalClassLoader, interfaces, new ObjectInvocationHandler(bean));
        bean = proxy;
        return bean;


        // Реализация с урока
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(bean.getClass());
//        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
//            if (!method.getName().equals("toString")) return proxy.invokeSuper(obj, args);
//            if (method.getParameterCount() != 0) return proxy.invokeSuper(obj, args);
//            return bean.getClass().getSimpleName() + "{" +
//                    Arrays.stream(bean.getClass().getDeclaredFields())
//                            .peek(f -> f.setAccessible(true))
//                            .map(f -> {
//                                try {
//                                    return f.getName() + "=" + f.get(bean);
//                                } catch (IllegalAccessException e) {
//                                    throw new RuntimeException(e);
//                                }
//                            })
//                            .reduce((s1, s2) -> s1 + ", " + s2)
//                            .orElse("") +
//                    "}";
//        });
//        return enhancer.create();
    }
}
