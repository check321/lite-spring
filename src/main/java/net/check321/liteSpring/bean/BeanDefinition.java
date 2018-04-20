package net.check321.liteSpring.bean;

/**
 * @author check321
 * @title 定义Bean的元信息（属性）
 * @description
 * @date 2018/4/20 11:09
 */
public class BeanDefinition {

    private String beanName;

    // bean类型
    private Class beanClazz;

    // bean类型名称
    private String beanClazzName;

    // bean实例
    private Object bean;

    // 属性列表
    private Properties properties;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public Class getBeanClazz() {
        return beanClazz;
    }

    public void setBeanClazz(Class beanClazz) {
        this.beanClazz = beanClazz;
    }

    public String getBeanClazzName() {
        return beanClazzName;
    }

    public void setBeanClazzName(String beanClazzName) {
        this.beanClazzName = beanClazzName;
        // 根据beanClazzName反射得到beanClazz
        try {
            this.beanClazz = Class.forName(beanClazzName);
        } catch (ClassNotFoundException e) {

        }
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
