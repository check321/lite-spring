package net.check321.liteSpring;

import net.check321.liteSpring.bean.BeanDefinition;
import net.check321.liteSpring.bean.Properties;
import net.check321.liteSpring.bean.Property;
import net.check321.liteSpring.factory.AutowireCapableBeanFactory;
import net.check321.liteSpring.factory.BeanFactory;

public class BeanFactoryTest {

    public static void main(String[] args) throws Exception {
        // IoC Context
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClazzName("net.check321.liteSpring.TestCallServiceImpl");

        // Properties
        Property property = new Property("msg","test");

        Properties properties = new Properties();
        properties.addProperty(property);
        beanDefinition.setProperties(properties);

        // Register bean
        final String beanName = "TestCallService";
        beanFactory.registerBean(beanName,beanDefinition);

        // Get bean
        TestCallService targetService = (TestCallService)beanFactory.getBean(beanName);
        targetService.call();

    }
}
