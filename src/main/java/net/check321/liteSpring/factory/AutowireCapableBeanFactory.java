package net.check321.liteSpring.factory;

import net.check321.liteSpring.bean.BeanDefinition;
import net.check321.liteSpring.bean.Properties;
import net.check321.liteSpring.bean.Property;

import java.lang.reflect.Method;

/**
 * @author check321
 * @title 可自动装配的bean工厂
 * @description
 * @date 2018/4/20 13:08
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实现bean属性封装逻辑
     *
     * @param bean
     * @param beanDefinition
     */
    @Override
    protected void setProperties(Object bean, BeanDefinition beanDefinition) throws Exception {
        Properties properties = beanDefinition.getProperties();
        if (properties.getProperties().isEmpty()) {
            return;
        }

        for (Property property : properties.getProperties()) {
            setProperty(bean, property);
        }
    }


    /**
     * 通过反射将Property属性设置到Bean
     *
     * @param bean
     * @param property
     */
    private void setProperty(Object bean, Property property) throws Exception {
        Object value = property.getValue();
        try {
            Method setter = bean.getClass().getDeclaredMethod(buildToCamelCase(property.getName()), value.getClass());
            setter.setAccessible(true); // 关闭jdk权限检查
            setter.invoke(bean, value);
        } catch (NoSuchMethodException e) {
            // 查找不到setter时尝试使用字段名
            Method field = bean.getClass().getDeclaredMethod(property.getName());
            field.setAccessible(true);
            field.invoke(bean, value);
        }

    }

    /**
     * 转为驼峰命名
     *
     * @param filedName
     * @return
     */
    private String buildToCamelCase(String filedName) {
        String fieldName = "set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);
        System.out.println(fieldName);
        return fieldName;
    }
}
