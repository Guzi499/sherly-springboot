package com.guzi.upr.model.eo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author 谷子毅
 * @date 2022/5/11
 */
@Data
public class UserEO {

    /** 用户id */
    @ExcelProperty("用户id")
    private Long userId;

    /** 昵称 */
    @ExcelProperty("昵称")
    private String nickname;

    /** 姓名 */
    @ExcelProperty("姓名")
    private String realName;

    /** 手机号 */
    @ExcelProperty("手机号")
    private String phone;

    /** 用户邮箱 */
    @ExcelProperty("用户邮箱")
    private String email;

    /** 性别 */
    @ExcelProperty("性别")
    private String gender;

    /** 部门名称 */
    @ExcelProperty("部门名称")
    private String departmentName;

    /** 状态 */
    @ExcelProperty("状态")
    private String enable;

    /** 最后登录时间 */
    @ExcelProperty("最后登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    /** 最后登录IP */
    @ExcelProperty("最后登录IP")
    private String lastLoginIp;
}
