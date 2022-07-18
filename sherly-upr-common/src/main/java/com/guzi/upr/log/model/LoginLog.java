package com.guzi.upr.log.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.guzi.upr.model.BaseModel;
import lombok.Data;

/**
 * @author 谷子毅
 * @date 2022/7/14
 */
@Data
@TableName("sys_login_log")
public class LoginLog extends BaseModel {
    /** 日志id */
    @TableId(type = IdType.AUTO)
    private Long logId;

    /** 登录账号 */
    private String username;

    /** 登录方式 */
    private Integer type;

    /** 请求ip */
    private String ip;

    /** 请求地址 */
    private String address;

    /** 请求系统 */
    private String os;

    /** 请求浏览器 */
    private String browser;

    /** 登录结果 */
    private Integer result;
}
