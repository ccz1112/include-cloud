package com.include.system.service;

import com.include.comm.entity.IncludeUser;
import com.include.comm.entity.R;

/**
 * @ projectName include-cloud-common
 * @ packageName com.include.service
 * @ className IIncludeUserService
 * @ author： chenshuo
 * @ version： 1.0
 * @ since： 2022-11-29 15:13
 */
public interface IIncludeUserService {

    IncludeUser loadUserByUsername(String userName);

    R<?> login(IncludeUser includeUser);

    R<?> getInfo(Long userId);

    R<?> save(IncludeUser includeUser);

    R<?> update(IncludeUser includeUser);

    R<?> delete(Long userId);
}
