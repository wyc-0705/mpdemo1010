package com.atguigu.mpdemo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component//交给spring管理
public class MyMetaObjectHandler implements MetaObjectHandler {
    //添加操作
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);//根据名称设置属性值 第三个为元数据对象
        this.setFieldValByName("updateTime",new Date(),metaObject);//根据名称设置属性值 第三个为元数据对象
        this.setFieldValByName("version",1,metaObject);//乐观锁


    }
    //修改操作
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);//根据名称设置属性值 第三个为元数据对象
    }
}
