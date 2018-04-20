package net.check321.liteSpring.io;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author check321
 * @title 资源类接口
 * @description 抽象定位配置文件
 * @date 2018/4/20 10:53
 */
public interface Resource {

    /**
     * @return 资源输入流
     * @throws IOException
     */
    InputStream getInputStrem() throws IOException;
}
