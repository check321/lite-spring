package net.check321.liteSpring.io;

import java.net.URL;

/**
 * @author check321
 * @title URL资源加载器
 * @description 实现于资源加载器接口
 * @date 2018/4/20 11:01
 */
public class URLResourceLoader implements ResourceLoader {

    final String location;

    public URLResourceLoader(String location) {
        this.location = location;
    }

    @Override
    public Resource getResource() {
        URL resource = this.getClass().getResource(location);
        return new URLResource(resource);
    }
}
