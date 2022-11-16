package com.itmowei.motionassistant.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (Xaiomi)实体类
 *
 * @author Mowei
 * @since 2022-11-13 18:32:28
 */
@Data
@TableName("xiaomi")
public class Xaiomi {

    //主键id
    @TableId(type = IdType.AUTO)
    private Integer id;

    //小米账号
    @TableField("user")
    private String user;

    //账号密码
    @TableField("password")
    private String password;

    //步数
    @TableField("steps")
    private String steps;
}

