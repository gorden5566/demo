package com.gorden5566.framework.spring.factorybean;

import com.gorden5566.framework.spring.bean.SpringBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * 用于生成 SpringBean 的 FactoryBean
 *
 * @author gorden5566
 * @date 2019/1/17
 */
@Component("springFactoryBean")
public class SpringFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new SpringBean();
    }

    @Override
    public Class<?> getObjectType() {
        return SpringBean.class;
    }

    @Override
    public String toString() {
        return "SpringFactoryBean{}";
    }
}
