package com.zhangxx.diybatis.sqlsession;

public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoClass
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoClass);

    /**
     * 释放资源
     */
    void close();
}
