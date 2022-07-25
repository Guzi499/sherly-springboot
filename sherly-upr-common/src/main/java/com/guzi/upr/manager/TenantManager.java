package com.guzi.upr.manager;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guzi.upr.log.model.OperationLog;
import com.guzi.upr.mapper.admin.TenantMapper;
import com.guzi.upr.model.admin.Tenant;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author 谷子毅
 * @date 2022/3/25
 */
@Service
public class TenantManager extends ServiceImpl<TenantMapper, Tenant> {

    /**
     * 租户查重
     *
     * @param tenantName
     * @param tenantCode
     * @return
     */
    public Tenant getByTenantNameOrTenantCode(String tenantName, String tenantCode) {
        LambdaQueryWrapper<Tenant> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Tenant::getTenantName, tenantName)
                .or()
                .eq(Tenant::getTenantCode, tenantCode);
        return this.getOne(wrapper);
    }

    /**
     * 租户条件分页
     *
     * @param page
     * @param tenantName
     * @param tenantCode
     * @return
     */
    public IPage<Tenant> listPage(IPage page, String tenantName, String tenantCode) {
        LambdaQueryWrapper<Tenant> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Tenant::getTenantId);
        if (StringUtils.hasText(tenantCode)) {
            wrapper.eq(Tenant::getTenantCode, tenantCode);
        }

        if (StringUtils.hasText(tenantName)) {
            wrapper.eq(Tenant::getTenantName, tenantName);
        }

        return this.page(page, wrapper);
    }
}
