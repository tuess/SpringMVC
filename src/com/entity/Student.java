package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private boolean sex;
    private Address address;
    private List<String> hobbies;
//    通过注解格式化日期,格式化前端传过来的数据
    @Past//当前时间以前
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }
}
