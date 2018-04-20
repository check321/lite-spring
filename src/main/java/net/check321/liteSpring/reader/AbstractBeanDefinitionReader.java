package net.check321.liteSpring.reader;

import net.check321.liteSpring.bean.BeanDefinition;
import net.check321.liteSpring.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
* @title 抽象配置读取类，读取配置构建BeanDefinition
* @description
* @author check321
* @date 2018/4/20 17:09
*/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private ResourceLoader resourceLoader;

    private Map<String,BeanDefinition> registery;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        this.registery = new HashMap<>();
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registery;
    }
}
