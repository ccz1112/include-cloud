package com.include.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.include.comm.entity.IncludeMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 11:10
 * @version： 1.0
 * @Description:
 **/
@Mapper
public interface IncludeMenuMapper extends BaseMapper<IncludeMenu> {

    List<IncludeMenu> getMenuList(Long userId);
}