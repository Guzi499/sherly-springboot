package com.guzi.upr.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guzi.upr.mapper.admin.UserRoleMapper;
import com.guzi.upr.model.admin.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谷子毅
 * @date 2022/3/25
 */
@Service
public class UserRoleManager extends ServiceImpl<UserRoleMapper, UserRole> {

    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 根据角色id删除用户角色数据
     *
     * @param roleId
     */
    public void removeUserRoleByRoleId(Long roleId) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getRoleId, roleId);
        this.remove(wrapper);
    }

    /**
     * 根据用户id删除用户角色数据
     *
     * @param userId
     */
    public void removeUserRoleByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId, userId);
        this.remove(wrapper);
    }

    /**
     * 保存用户角色数据
     *
     * @param userId
     * @param roleIds
     */
    public void saveUserRole(Long userId, List<Long> roleIds) {
        userRoleMapper.saveUserRole(userId, roleIds);
    }
}
