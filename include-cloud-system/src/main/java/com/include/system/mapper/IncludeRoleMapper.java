package com.include.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.include.comm.entity.IncludeRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 11:10
 * @version： 1.0
 * @Description:
 **/
@Mapper
public interface IncludeRoleMapper extends BaseMapper<IncludeRole> {

    @Select(" select r.* from " +
            " include_role as r" +
            " left join include_user_role as ur on r.id = ur.role_id" +
            " where ur.user_id = #{userId}")
    List<IncludeRole> getRoleList(Long userId);
}