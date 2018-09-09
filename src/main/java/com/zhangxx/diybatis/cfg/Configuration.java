package com.zhangxx.diybatis.cfg;

import java.util.Map;

/**
 * 用于封装读取的配置文件
 */
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;
    //map 集合   Map<唯一标识，Mapper>  用于保存映射文件中的 sql 标识及 sql 语句
    private Map<String,Mapper> mappers;

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers = mappers;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
