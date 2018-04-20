package net.check321.liteSpring.factory;

import net.check321.liteSpring.bean.BeanDefinition;

/**
 * @author check321
 * @title 抽象规范Bean工厂的行为
 * @description
 * @date 2018/4/20 11:18
 */
public interface BeanFactory {

    /**
     * 向容器注册bean
     *
     * @param beanName
     * @param beanDefinition
     * @throws Exception
     */
    void registerBean(String beanName, BeanDefinition beanDefinition) throws Exception;

    /**
     * 根据beanName获取bean
     *
     * @param beanName
     * @return
     * @throws Exception
     */
    Object getBean(String beanName) throws Exception;
}
