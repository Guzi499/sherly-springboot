package com.guzi.sherly.model.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.guzi.sherly.model.BaseModel;
import com.guzi.sherly.modules.storage.model.OssClientConfig;
import lombok.Data;

/**
 * @author 谷子毅
 * @date 2022/6/11
 */
@Data
@TableName(value = "sys_oss_config", autoResultMap = true)
public class OssConfig extends BaseModel {
    /** 配置编号 */
    @TableId(type = IdType.AUTO)
    private Long configId;

    /** 配置名称 */
    private String configName;

    /** 存储方式[enum] */
    private Integer type;

    /** 描述 */
    private String description;

    /** 启用禁用[enum] */
    private Integer enable;

    /** 具体配置 */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private OssClientConfig config;
}
