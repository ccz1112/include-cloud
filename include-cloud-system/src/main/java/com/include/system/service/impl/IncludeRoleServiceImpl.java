package com.include.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.include.comm.entity.IncludeRole;
import com.include.comm.entity.R;
import com.include.system.mapper.IncludeRoleMapper;
import com.include.system.service.IIncludeRoleService;
import lombok.Cleanup;
import lombok.val;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName include-cloud-common
 * @packageName com.include.service
 * @className IIncludeUserService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-29 15:13
 */
@Service
public class IncludeRoleServiceImpl implements IIncludeRoleService {

    private final IncludeRoleMapper includeRoleMapper;


    public IncludeRoleServiceImpl(IncludeRoleMapper includeRoleMapper) {
        this.includeRoleMapper = includeRoleMapper;
    }

    @Override
    public R insertRole(IncludeRole role) {

        includeRoleMapper.insert(role);
        return R.oK();
    }

    @Override
    public R roleList(IncludeRole role) {
        Page page = new Page();
        QueryWrapper wrapper = new QueryWrapper();
        IPage<IncludeRole> list = includeRoleMapper.selectPage(page,wrapper);
        return R.oK(list);
    }

    @Override
    public R updateRole(IncludeRole role) {
        includeRoleMapper.updateById(role);
        return R.oK();
    }

    @Override
    public R deleteRole(Long id) {
        includeRoleMapper.deleteById(id);
        return R.oK();
    }

    @Override
    public R roleInfo(Long id) {
        IncludeRole role = includeRoleMapper.selectById(id);
        return R.oK(role);
    }

    @Override
    public List<IncludeRole> getUserRoleList(Long userId) {
        return includeRoleMapper.getRoleList(userId);
    }
}
