package ru.marinin.toString;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ObjectInvocationHandler implements InvocationHandler {
    private Object obj;

    public ObjectInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getName().equals("toString")) {
            Field[] fields = obj.getClass().getDeclaredFields();
            String res = obj.getClass().getSimpleName() + ": ";
            for (Field field : fields) {
                res = res + field.getName() +"="+ field.get(obj) + ", ";
            }
            return res.substring(0,res.length()-2);
        }
        return method.invoke(obj,args);
    }
}