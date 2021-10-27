package com.atguigu.p2.bean;

/**
 * @author fox Email:963614756@qq.com
 * @Description Customer为实体对象，用来封装客户信息
 * @date 2021年8月28日16点15分
 */
public class Customer {
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 性别
     */
    private char gender;
    /**
     * 年龄
     */
    private int age;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetails() {
        return name + "\t" + gender + "\t" + age + "\t\t" + phone + "\t" + email;
    }

    public Customer() {
    }

    public Customer(String name, char gender, int age, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

}
