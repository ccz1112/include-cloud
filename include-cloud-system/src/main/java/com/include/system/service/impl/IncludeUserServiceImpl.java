package com.include.system.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.comm.constatant.Column;
import com.include.comm.entity.IncludeMenu;
import com.include.comm.entity.IncludeUser;
import com.include.comm.entity.R;
import com.include.comm.enumeratr.ErrorEnum;
import com.include.comm.exception.BusinessException;
import com.include.system.mapper.IncludeMenuMapper;
import com.include.system.mapper.IncludeUserMapper;
import com.include.system.service.IIncludeUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ author: chenshuo
 * @ Date: 2023-02-15
 * @ Time: 11:00
 * @ version： 1.0
 * @ Description:
 **/
@Service
@AllArgsConstructor
public class IncludeUserServiceImpl implements IIncludeUserService {




    private final IncludeUserMapper includeUserMapper;

    private final IncludeMenuMapper includeMenuMapper;


    @Override
    public IncludeUser loadUserByUsername(String userName) {
        /*LambdaQueryWrapper queryWrapper = Wrappers
                .lambdaQuery()
                .eq(IncludeUser::getUserName,userName);*/

        QueryWrapper<IncludeUser> queryWrapper = new QueryWrapper<IncludeUser>();
        queryWrapper.eq(Column.IncludeUser.USER_NAME,userName);


        IncludeUser includeUser = includeUserMapper.selectOne(queryWrapper);
        if(includeUser==null){
            throw new BusinessException(ErrorEnum.BUSINESS_ERROR.getCode(),"获取用户信息失败");
        }
        List<IncludeMenu> menuList = includeMenuMapper.getMenuList(includeUser.getId());

        List<String> permissionList = menuList.stream().map(res->res.getPermission()).collect(Collectors.toList());
        String encodePassword = BCrypt.hashpw(includeUser.getPassword());
        includeUser.setPassword(encodePassword);
        includeUser.setPermissionList(permissionList);
        return includeUser;
    }

    public static void main(String[] args) {
        String encodePassword = BCrypt.hashpw("123456");
        System.out.println(encodePassword);
    }

    @Override
    public R login(IncludeUser includeUser) {
        includeUserMapper.insert(includeUser);
        return R.oK();
    }

    @Override
    public R getInfo(Long userId) {
        return null;
    }

    @Override
    public R save(IncludeUser includeUser) {
        return null;
    }

    @Override
    public R<?> update(IncludeUser includeUser) {
        return R.oK();
    }

    @Override
    public R delete(Long userId) {
        return null;
    }
}