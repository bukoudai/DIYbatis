package com.zhangxx.diybatis.sqlsession;

public interface SqlSessionFactory {


    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession() throws Exception;

}
