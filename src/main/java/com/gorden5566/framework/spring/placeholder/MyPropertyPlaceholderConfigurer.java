package com.gorden5566.framework.spring.placeholder;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.util.StringValueResolver;

import java.util.Properties;

/**
 * @author gorden5566
 * @date 2019/04/20
 */
public class MyPropertyPlaceholderConfigurer extends PlaceholderConfigurerSupport {

    /**
     * Visit each bean definition in the given bean factory and attempt to replace ${...} property
     * placeholders with values from the given properties.
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
        throws BeansException {

        StringValueResolver valueResolver = new MyPropertyPlaceholderConfigurer.PlaceholderResolvingStringValueResolver(props);
        doProcessProperties(beanFactoryToProcess, valueResolver);
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {

        private final PropertyPlaceholderHelper helper;

        private final PropertyPlaceholderHelper.PlaceholderResolver resolver;

        public PlaceholderResolvingStringValueResolver(Properties props) {
            this.helper = new PropertyPlaceholderHelper(placeholderPrefix, placeholderSuffix, valueSeparator, ignoreUnresolvablePlaceholders);
//            this.helper = new PropertyPlaceholderHelper("#[", "]", valueSeparator, ignoreUnresolvablePlaceholders);
            this.resolver = new MyPropertyPlaceholderConfigurer.PropertyPlaceholderConfigurerResolver(props);
        }

        @Override
        public String resolveStringValue(String strVal) throws BeansException {
            return this.helper.replacePlaceholders(strVal, this.resolver);
        }
    }


    private class PropertyPlaceholderConfigurerResolver implements PropertyPlaceholderHelper.PlaceholderResolver {

        private final Properties props;

        private PropertyPlaceholderConfigurerResolver(Properties props) {
            this.props = props;
        }

        @Override
        public String resolvePlaceholder(String placeholderName) {

            return props.getProperty(placeholderName);
        }
    }
}
