package net.check321.liteSpring;

import net.check321.liteSpring.bean.BeanDefinition;
import net.check321.liteSpring.bean.Properties;
import net.check321.liteSpring.bean.Property;
import net.check321.liteSpring.factory.AutowireCapableBeanFactory;
import net.check321.liteSpring.factory.BeanFactory;
import net.check321.liteSpring.io.URLResourceLoader;
import net.check321.liteSpring.reader.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryTest {

    private static final String beanName = "testCallService";

    public static void main(String[] args) throws Exception {
//        beanFactorTest();
        xmlReaderTest();
    }

    private static void xmlReaderTest() throws Exception {

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new URLResourceLoader("lite-spring.xml"));
        reader.loadBeanDefinition();

        // BeanFactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        Map<String, BeanDefinition> registry = reader.getRegistry();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : registry.entrySet()
                ) {
            beanFactory.registerBean(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // GetBean
        TestCallService testCallService = (TestCallService) beanFactory.getBean(beanName);
        testCallService.call();
    }


    private static void beanFactorTest() throws Exception {
        // IoC Context
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClazzName("net.check321.liteSpring.TestCallServiceImpl");

        // Properties
        Property property = new Property("msg", "test");

        Properties properties = new Properties();
        properties.addProperty(property);
        beanDefinition.setProperties(properties);

        // Register bean
        beanFactory.registerBean(beanName, beanDefinition);

        // Get bean
        TestCallService targetService = (TestCallService) beanFactory.getBean(beanName);
        targetService.call();
    }
}
