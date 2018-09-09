package com.zhangxx.diybatis.sqlsession;

import com.zhangxx.diybatis.cfg.Configuration;
import com.zhangxx.diybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.zhangxx.diybatis.utils.XMLConfigBuilder;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * 用于构建 SqlSessionFactory
 */
public class SqlSessionFactoryBuilde {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) throws DocumentException {

        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return  new DefaultSqlSessionFactory(cfg);
    }
}
