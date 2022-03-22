package com.guzi.upr.model.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.guzi.upr.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 谷子毅
 * @email guzyc@digitalchina.com
 * @date 2022/3/17
 */
@Data
@TableName("sys_menu")
public class Menu extends BaseModel {
    /** 菜单id */
    @ApiModelProperty("菜单id")
    @TableId(type = IdType.AUTO)
    private Integer menuId;

    /** 菜单名 */
    @ApiModelProperty("菜单名")
    private String menuName;

    /** 父菜单id */
    @ApiModelProperty("父菜单id")
    private Integer parentId;

    /** 菜单路径 */
    @ApiModelProperty("菜单路径")
    private String link;

    /** 菜单图标 */
    @ApiModelProperty("菜单图标")
    private String icon;

    /** 排序 */
    @ApiModelProperty("排序")
    private Integer sort;
}
