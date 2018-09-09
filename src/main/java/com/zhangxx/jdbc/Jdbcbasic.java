package com.zhangxx.jdbc;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.sql.*;
import java.util.List;

public class Jdbcbasic {


    /**
     * jdbc的执行顺序
     *
     *
     */
    public void jdbc(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String driver;
            String url;
            String username;
            String password;
            String xmlurl;
            xmlurl="diybatisConfiguration.xml";
            //定义封装连接信息的配置对象（mybatis的配置对象）
            Configuration cfg = new Configuration();

            //1.获取SAXReader对象
            SAXReader reader = new SAXReader();
            //2.根据字节输入流获取Document对象
            Document document = reader.read(xmlurl);
            //3.获取根节点
            Element root = document.getRootElement();
            //4.使用xpath中选择指定节点的方式，获取所有property节点
            List<Element> propertyElements = root.selectNodes("//dataSource/property");
            //5.遍历节点
            for(Element propertyElement : propertyElements){
                //判断节点是连接数据库的哪部分信息
                //取出name属性的值
                String name = propertyElement.attributeValue("name");
                if("driver".equals(name)){
                    //表示驱动
                    //获取property标签value属性的值
                    driver = propertyElement.attributeValue("value");
                    cfg.setDriver(driver);
                }
                if("url".equals(name)){
                    //表示连接字符串
                    //获取property标签value属性的值
                    url = propertyElement.attributeValue("value");
                    cfg.setUrl(url);
                }
                if("username".equals(name)){
                    //表示用户名
                    //获取property标签value属性的值
                    username = propertyElement.attributeValue("value");
                    cfg.setUsername(username);
                }
                if("password".equals(name)){
                    //表示密码
                    //获取property标签value属性的值
                    password = propertyElement.attributeValue("value");
                    cfg.setPassword(password);
                }
            }

            //加载数据库驱动
            Class.forName(cfg.getDriver());

            //通过驱动管理类获取数据库链接
            connection =  DriverManager.getConnection(cfg.getUrl(), cfg.getUrl(), cfg.getPassword());




            //定义sql语句 ?表示占位符
            String sql = "select * from user";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            //向数据库发出sql执行查询，查询出结果集
            resultSet =  preparedStatement.executeQuery();
            //遍历查询结果集
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if(null != resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null != connection){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
