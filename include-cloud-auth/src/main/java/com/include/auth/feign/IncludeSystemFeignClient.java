package com.include.auth.feign;

import com.include.comm.config.RibbonConfig;
import com.include.comm.entity.IncludeUser;
import com.include.comm.entity.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @projectName include-cloud-common
 * @packageName com.include.feign
 * @className IncludeGoodsFeignClient
 * @author： chenshuo
 * @version： 1.0
 * @since： 2022-11-22 14:27
**/

//配置ribbon规则,可只指定一个feign
@FeignClient(value = "include-system",configuration = RibbonConfig.class)
public interface IncludeSystemFeignClient {

    @PostMapping("/includeUser/loadUserByUsername")
    IncludeUser loadUserByUsername(@RequestParam("userName") String userName);
}
