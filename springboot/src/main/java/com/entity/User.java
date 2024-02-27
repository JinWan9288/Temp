package com.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "user") // mybatis-plus默认使用实体类的名字查询-> User -> user,数据库表名为user 加上 否则会报找不到
public class User {
//  @TableId(value = "id") //主键的值是这个id
    @TableId(type = IdType.AUTO)
    private Integer  id;  // 用的是Interger 而不是 int
    private String nickname;
    private String username;

    @JsonIgnore // 不展示密码在前端
    private String passwords;

    private Integer age;
    private Integer sex;
    private String phone;
    private String address;
    private String email;
    private Integer roleId; // 在数据库中原本是 role-id ,idea读取 roleId 才会读出role-id
    private String isvalid;//在数据库中原本是isValid,idea读取isValid变成isvalid

//    @TableField("isvalid") //TableField是驼峰映射，这里写idea读取 isvalid,声明可以原样写
//    private String isValid; //数据库里叫isValid

    private String createTime;

    @TableField("avatar_url") //数据库中是avatar_url
    private String avatar;
//  private String avatarUrl;
}

// ssm mvc postman具体流程 IService BaseMapper
// 为什么这里采用Integer 而不是int
// jdbc
//mybatis mybatis-plus 是
// 多条件查询  mybatis-plus
