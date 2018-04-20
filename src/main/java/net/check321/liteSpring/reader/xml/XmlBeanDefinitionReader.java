package net.check321.liteSpring.reader.xml;

import net.check321.liteSpring.bean.BeanDefinition;
import net.check321.liteSpring.bean.Property;
import net.check321.liteSpring.io.Resource;
import net.check321.liteSpring.io.ResourceLoader;
import net.check321.liteSpring.reader.AbstractBeanDefinitionReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author check321
 * @title 从XML配置文件中读取配置并构成BeanDefinition
 * @description
 * @date 2018/4/20 17:15
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinition() throws Exception {
        Resource resource = getResourceLoader().getResource();
        InputStream in = resource.getInputStrem();
        loadBeanDefinitions(in);
    }


    /**
     * 读取xml配置文件注册BeanDefinition
     *
     * @param inputStream
     * @throws Exception
     */
    protected void loadBeanDefinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputStream);
        // 解析bean
        registerBeanDefinitions(doc);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc) {
        // 根节点
        Element root = doc.getDocumentElement();

        parseBeanDefinitions(root);
    }

    /**
     * 遍历子节点
     *
     * @param root
     */
    protected void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                processBeanDefinition(ele);
            }
        }
    }

    /**
     * 将节点按属性转换成BeanDefinition
     *
     * @param ele
     */
    protected void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("id");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClazzName(className);
        this.getRegistry().put(name, beanDefinition);
    }

    /**
     * 设置Properties
     *
     * @param ele
     * @param beanDefinition
     */
    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beanDefinition.getProperties().addProperty(new Property(name, value));
                }
            }
        }
    }
}



