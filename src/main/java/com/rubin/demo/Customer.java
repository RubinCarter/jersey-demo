package com.rubin.demo;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * xx x
 */
@XmlRootElement
public class Customer implements Serializable {

    @FormParam("name")
    private String name;
    @FormParam("age")
    private Integer age;
    @FormParam("addr")
    private String addr;
    public Customer() {
    }
    public Customer(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @XmlAttribute
    public String getName() {
        return name;
    }

    @XmlAttribute
    public Integer getAge() {
        return age;
    }

    @XmlAttribute
    public String getAddr() {
        return addr;
    }
}