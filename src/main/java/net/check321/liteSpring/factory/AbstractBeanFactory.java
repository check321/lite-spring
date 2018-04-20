package net.check321.liteSpring.factory;

import net.check321.liteSpring.bean.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author check321
 * @title 抽象Bean工厂实现BeanFac接口
 * @description 各种实现Bean工厂需要继承该抽象基础类
 * @date 2018/4/20 11:20
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    // 储存Bean属性容器
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    // 储存Bean属性名称
    private final List<String> baanDefinitionNames = new ArrayList<>();

    @Override
    public void registerBean(String beanName, BeanDefinition beanDefinition) throws Exception {
        // 储存bean相关信息
        baanDefinitionNames.add(beanName);
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new IllegalArgumentException("Bean named [" + beanName + "] is undefinied.");
        }

        Object bean = beanDefinition.getBean();
        if (null == bean) {
            // 创建bean实例
            bean = createBean(beanDefinition);
            beanDefinition.setBean(bean);
        }
        return bean;
    }


    /**
     * 根据BeanDefinition创建Bean实例
     *
     * @param beanDefinition
     * @return
     */
    protected Object createBean(BeanDefinition beanDefinition) throws Exception {
        Object instance = createBeanInstance(beanDefinition);
        beanDefinition.setBean(instance);
        setProperties(instance, beanDefinition);
        return instance;
    }


    /**
     * 根据BeanDefinition的Class反射创建实例
     *
     * @param beanDefinition
     * @return
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClazz().newInstance();
    }

    /**
     * 设置bean属性值 ， 交给子类实现
     *
     * @param bean
     * @param beanDefinition
     */
    protected abstract void setProperties(Object bean, BeanDefinition beanDefinition) throws Exception;


}
