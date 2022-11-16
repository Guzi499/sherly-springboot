package com.guzi.sherly.modules.security.model;

import lombok.Data;

/**
 * SecurityModel对象，存储请求周期的用户信息
 *
 * @author 谷子毅
 * @date 2022/3/24
 */
@Data
public class SecurityModel {

    /** 用户编号 */
    private Long userId;

    /** 手机号 */
    private String phone;

    /** 租户代码 */
    private String tenantCode;

    /** 特殊操作数据库code */
    private String operateTenantCode;

    /** 昵称 */
    private String nickname;

    /** 姓名 */
    private String realName;

    /** 会话编号 */
    private String sessionId;
}
