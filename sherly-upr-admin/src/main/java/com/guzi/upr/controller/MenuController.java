package com.guzi.upr.controller;

import com.guzi.upr.model.Result;
import com.guzi.upr.model.dto.MenuInsertDTO;
import com.guzi.upr.model.dto.MenuUpdateDTO;
import com.guzi.upr.model.vo.MenuVO;
import com.guzi.upr.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谷子毅
 * @date 2022/3/24
 */
@RestController
@RequestMapping("/api/menu")
@Api(tags = "菜单相关")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/list/tree")
    @ApiOperation("查询菜单树")
    public Result<List<MenuVO>> listTree() {
        return Result.success(menuService.listTree());
    }

    @PostMapping("/save/one")
    @ApiOperation("菜单新增")
    public Result saveOne(@RequestBody MenuInsertDTO dto) {
        menuService.saveOne(dto);
        return Result.success();
    }

    @DeleteMapping("/remove/one")
    @ApiOperation("菜单删除")
    public Result removeOne(@RequestParam Long menuId) {
        menuService.removeOne(menuId);
        return Result.success();
    }

    @PutMapping("/update/one")
    @ApiOperation("菜单修改")
    public Result updateOne(@RequestBody MenuUpdateDTO dto) {
        menuService.updateOne(dto);
        return Result.success();
    }
}
