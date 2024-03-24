package ru.marinin.random;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RegistryRandomBeanPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        if (!beanFactory.containsBeanDefinition("random")) {

//            **Решение с занятия**
//            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(int.class, () -> ThreadLocalRandom.current().nextInt(101));
//            builder.setScope("prototype");
//            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
//            beanDefinitionRegistry.registerBeanDefinition("random", builder.getBeanDefinition());


            BeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClassName(Random.class.getName());
            beanDefinition.setScope("prototype");
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
            registry.registerBeanDefinition("random", beanDefinition);

        }
    }
}
