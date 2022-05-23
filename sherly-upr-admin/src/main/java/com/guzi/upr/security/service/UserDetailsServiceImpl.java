package com.guzi.upr.security.service;

import com.guzi.upr.manager.*;
import com.guzi.upr.model.admin.*;
import com.guzi.upr.security.SherlyUserDetails;
import com.guzi.upr.security.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 谷子毅
 * @date 2022/5/5
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private MenuManager menuManager;

    @Autowired
    private RoleMenuManager roleMenuManager;

    @Autowired
    private AccountUserManager accountUserManager;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        // 设置当前操作租户存入当前执行线程
        SecurityModel securityModel = new SecurityModel();
        securityModel.setOperateTenantCode("sherly");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(securityModel, null));

        // 查询用户租户信息
        AccountUser accountUser = accountUserManager.getByPhone(phone);
        if (accountUser == null) {
            throw new BadCredentialsException("当前账号未注册！");
        }
        String lastLoginTenantCode = accountUser.getLastLoginTenantCode();

        // 设置当前操作租户存入当前执行线程
        securityModel.setOperateTenantCode(lastLoginTenantCode);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(securityModel, null));

        // 根据查询参数查询用户信息
        User user = userManager.getByPhone(phone);

        List<Role> roles = roleManager.listByUserId(user.getUserId());
        List<Long> roleIds = roles.stream().map(Role::getRoleId).collect(Collectors.toList());
        List<RoleMenu> roleMenus = roleMenuManager.listByRoleIds(roleIds);
        List<Long> menuIds = roleMenus.stream().map(RoleMenu::getMenuId).distinct().collect(Collectors.toList());
        List<Menu> menus = menuManager.listByIds(menuIds);
        List<String> permissions = menus.stream().filter(e -> e.getMenuType() != 1).map(Menu::getPermission).collect(Collectors.toList());

        // 响应userDetails用于登录校验
        SherlyUserDetails sherlyUserDetails = new SherlyUserDetails();
        sherlyUserDetails.setUser(user);
        sherlyUserDetails.setAccountUser(accountUser);
        sherlyUserDetails.setPermissions(permissions);

        return sherlyUserDetails;
    }
}
