package net.check321.liteSpring.bean;

/**
 * @author check321
 * @title bean属性对象
 * @description
 * @date 2018/4/20 13:53
 */
public class Property {

    private final String name;

    private final Object value;

    public Property(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
