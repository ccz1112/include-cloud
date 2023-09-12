package com.include.order.controller;

import com.include.comm.entity.IncludeOrder;
import com.include.comm.entity.R;
import com.include.order.service.IIncludeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 11:51
 * @version： 1.0
 * @Description:
 **/
@RestController
@RefreshScope
@RequestMapping("includeOrder")
public class IncludeOrderController {

    private final IIncludeOrderService includeOrderService;

    @Value("${my.property}")
    private String myProperty;

    @Autowired
    public IncludeOrderController(IIncludeOrderService includeOrderService) {
        this.includeOrderService = includeOrderService;
    }

    @RequestMapping("demo")
    public R demo(){
        return R.oK(myProperty);
    }

    @RequestMapping("getList")
    public R getList(@RequestBody IncludeOrder includeOrder){
        return includeOrderService.getList(includeOrder);
    }

    @RequestMapping("getInfo")
    public R getInfo(Integer id){
        return includeOrderService.getInfo(id);
    }

    @RequestMapping("saveOrder")
    public R saveOrder(@RequestBody IncludeOrder includeOrder){
        return includeOrderService.saveOrder(includeOrder);
    }
}