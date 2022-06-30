package com.guzi.upr.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 谷子毅
 * @date 2022/3/24
 */
@Data
public class MenuUpdateDTO {

    /** 菜单id */
    @ApiModelProperty("菜单id")
    @NotNull
    private Long menuId;

    /** 菜单名称 */
    @ApiModelProperty("菜单名称")
    @NotBlank
    private String menuName;

    /** 菜单类型 1目录 2菜单 3按钮 */
    @ApiModelProperty("菜单类型 1目录 2菜单 3按钮")
    @NotNull
    private Integer menuType;

    /** 权限 */
    @ApiModelProperty("权限")
    private String permission;

    /** 父菜单id */
    @ApiModelProperty("父菜单id")
    @NotNull
    private Long parentId;

    /** 菜单路径  */
    @ApiModelProperty("菜单路径")
    private String link;

    /** 菜单图标 */
    @ApiModelProperty("菜单图标")
    private String icon;

    /** 排序 */
    @ApiModelProperty("排序")
    @NotNull
    private Integer sort;
}
