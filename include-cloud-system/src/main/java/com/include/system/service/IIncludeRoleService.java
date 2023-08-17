package com.include.system.service;

import com.include.comm.entity.IncludeRole;
import com.include.comm.entity.R;

import java.util.List;

/**
 * @projectName include-cloud-common
 * @packageName com.include.service
 * @className IIncludeUserService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-29 15:13
 */
public interface IIncludeRoleService {

    R insertRole(IncludeRole role);

    R roleList(IncludeRole role);

    R updateRole(IncludeRole role);

    R deleteRole(Long id);

    R roleInfo(Long id);

    List<IncludeRole> getUserRoleList(Long userId);
}
