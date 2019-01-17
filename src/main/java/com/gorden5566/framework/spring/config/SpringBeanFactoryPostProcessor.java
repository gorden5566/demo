package com.gorden5566.framework.spring.config;

import com.gorden5566.framework.spring.bean.After;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author gorden5566
 * @date 2019/1/17
 */
@Component
public class SpringBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 修改Before类的BeanDefinition，改为After类型
        GenericBeanDefinition before = (GenericBeanDefinition) beanFactory.getBeanDefinition("before");
        before.setBeanClass(After.class);
    }
}
