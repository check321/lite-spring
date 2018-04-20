package net.check321.liteSpring.reader;

/**
 * @author check321
 * @title 读取Bean配置
 * @description
 * @date 2018/4/20 17:02
 */
public interface BeanDefinitionReader {

    /**
     * 从外部读取BeanDefinition
     *
     */
    void loadBeanDefinition() throws Exception;

}
