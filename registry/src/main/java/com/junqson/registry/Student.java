package com.junqson.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Descriptions
 * @Company
 * @Author Junqson
 * @Date 2019/4/2 14:22
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private Integer id;
    private String name;
    private String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Autowired
    private ValueContainer vc;

    @Override
    public String toString() {
        return vc.school + "  " + id + "  " + name + " " + sex;
    }

}
