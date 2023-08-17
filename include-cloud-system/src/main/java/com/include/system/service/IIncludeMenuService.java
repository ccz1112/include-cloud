package com.include.system.service;

import com.include.comm.entity.IncludeMenu;
import com.include.comm.entity.R;

import java.util.List;

/**
 * @projectName include-cloud-common
 * @packageName com.include.service
 * @className IIncludeMenuService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-29 15:13
 */
public interface IIncludeMenuService {

    R saveMenu(IncludeMenu menu);

    R menuList(IncludeMenu menu);

    R updateMenu(IncludeMenu menu);

    R deleteMenu(Long id);

    R menuInfo(Long id);

    R bindingRoleMenu();

    List<IncludeMenu> getMenuList(Long userId);

}
