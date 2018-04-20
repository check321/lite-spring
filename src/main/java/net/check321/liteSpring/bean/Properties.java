package net.check321.liteSpring.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author check321
 * @title 属性包装类
 * @description 包装了Bean里的所有属性值，用一个List<Property>维护
 * @date 2018/4/20 13:57
 */
public class Properties {

    private final List<Property> propertyList = new ArrayList<>();

    /**
     * 新增属性
     *
     * @param property
     */
    public void addProperty(Property property) {
        this.propertyList.add(property);
    }

    /**
     * 获取bean所有属性
     *
     * @return
     */
    public List<Property> getProperties() {
        return this.propertyList;
    }

    public Properties() {
    }
}
