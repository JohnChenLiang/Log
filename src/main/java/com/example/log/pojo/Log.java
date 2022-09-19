package com.example.log.pojo;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private Integer id;

    private String model; //模块名称

    private String method; //方法名称

    private String params; //参数

    private Date createDate; //创建时间

    private String createMan; //操作人名字。也可以改为放Int类型的 操作人的id

    //发送消息体的时候如果传递的是对象，那么需要注意你必须要实现序列化接口生成序列化ID
    //需要这行 和 类名那的implements Serializable
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", createDate=" + createDate +
                ", createMan='" + createMan + '\'' +
                '}';
    }
}
