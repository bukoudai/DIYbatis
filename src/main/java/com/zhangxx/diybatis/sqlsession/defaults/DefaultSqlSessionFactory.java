package com.zhangxx.diybatis.sqlsession.defaults;

import com.zhangxx.diybatis.cfg.Configuration;
import com.zhangxx.diybatis.sqlsession.SqlSession;
import com.zhangxx.diybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {


    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() throws Exception {
        return new DefaultSqlSession(cfg);
    }
}
