package com.include.system.service.impl;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.comm.entity.IncludeMenu;
import com.include.comm.entity.R;
import com.include.comm.util.TransactionUtils;
import com.include.system.mapper.IncludeMenuMapper;
import com.include.system.mapper.IncludeRoleMapper;
import com.include.system.service.IIncludeMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @projectName include-cloud-common
 * @packageName com.include.service
 * @className IncludeMenuServiceImpl
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-29 15:13
 */
@Service
public class IncludeMenuServiceImpl implements IIncludeMenuService {

    private final IncludeRoleMapper includeRoleMapper;

    private final IncludeMenuMapper includeMenuMapper;

    private final TransactionUtils transactionUtils;

    public IncludeMenuServiceImpl(IncludeRoleMapper includeRoleMapper,
                                  IncludeMenuMapper includeMenuMapper, TransactionUtils transactionUtils) {
        this.includeRoleMapper = includeRoleMapper;
        this.includeMenuMapper = includeMenuMapper;
        this.transactionUtils = transactionUtils;
    }


    @Override
    public R saveMenu(IncludeMenu menu) {
        includeMenuMapper.insert(menu);
        return R.oK();
    }

    @Override
    @Transactional
    public R menuList(IncludeMenu menu) {
        QueryWrapper wrapper = new QueryWrapper();
        List<IncludeMenu> list = includeMenuMapper.selectList(wrapper);

        transactionUtils.doTx();
        return R.oK(list);
    }


    @Override
    public R updateMenu(IncludeMenu menu) {
        includeMenuMapper.updateById(menu);
        return R.oK();
    }

    @Override
    public R deleteMenu(Long id) {
        includeMenuMapper.deleteById(id);
        return R.oK();
    }

    @Override
    public R menuInfo(Long id) {
        IncludeMenu includeMenu = includeMenuMapper.selectById(id);
        return R.oK(includeMenu);
    }

    @Override
    public R bindingRoleMenu() {
        return null;
    }

    @Override
    public List<IncludeMenu> getMenuList(Long userId) {
        return includeMenuMapper.getMenuList(userId);
    }
}
