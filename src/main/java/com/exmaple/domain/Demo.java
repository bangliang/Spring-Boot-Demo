package com.exmaple.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

// 建表，无需sql语句
@Entity
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // 表单验证，性别不能为空
    @NotEmpty(message = "性别必填")
    private String sexy;

    // 表单验证，年龄必须大于18，年龄不能为空
    @NotNull(message = "年龄必填")
    @Min(value = 18, message = "未成年禁止入内！")
    private Integer age;

    public void setSexy(String sexy) { this.sexy = sexy; }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSexy() { return sexy; }

    //    无参的构造方法
    public Demo(){

    }

    // toString的方法
    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
