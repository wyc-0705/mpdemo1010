package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.javafx.beans.IDProperty;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //自动增长
    private Long id;
    private String name;
    private Integer age;
    private String email;
    //自动填充第一步  进行自动填充属性注解
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)//有默认值1
    private Integer version;//版本号
}
